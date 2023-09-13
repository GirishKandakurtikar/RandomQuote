package com.example.randomquotedemoapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val quoteId : Int,
    val id: Int,
    val author: String,
    val quote: String
)