package com.example.randomquotedemoapp.api

import com.example.randomquotedemoapp.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>

}