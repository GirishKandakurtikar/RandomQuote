package com.example.randomquotedemoapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import com.cheezycode.randomquote.api.QuoteService
import com.example.randomquotedemoapp.db.QuoteDatabase
import com.example.randomquotedemoapp.models.QuoteList
import com.example.randomquotedemoapp.utils.NetworkUtils
import com.example.randomquotedemoapp.api.QuoteService

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes()
            if(result?.body() != null){
                if(quoteDatabase.quoteDao().getQuotes().isEmpty()) {
                    quoteDatabase.quoteDao().addQuotes(result.body()!!.quotes)
                }
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }

    }
}







