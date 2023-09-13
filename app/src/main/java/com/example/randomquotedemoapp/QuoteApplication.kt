package com.example.randomquotedemoapp

import android.app.Application
import com.example.randomquotedemoapp.api.QuoteService
import com.example.randomquotedemoapp.api.RetrofitHelper
import com.example.randomquotedemoapp.db.QuoteDatabase
import com.example.randomquotedemoapp.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}