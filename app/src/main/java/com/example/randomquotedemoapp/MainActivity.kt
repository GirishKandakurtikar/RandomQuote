package com.example.randomquotedemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomquotedemoapp.repository.QuoteRepository
import com.example.randomquotedemoapp.viewmodels.MainAdapter
import com.example.randomquotedemoapp.viewmodels.MainViewModel
import com.example.randomquotedemoapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var myRecyclerView:RecyclerView
    lateinit var myAdapter: MainAdapter
    //lateinit var recCount:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        myRecyclerView = findViewById(R.id.MyRecyclerView)
        //recCount = findViewById(R.id.recordCount)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.quotes.size.toString()+ "  Records", Toast.LENGTH_SHORT).show()
            //recCount.text = it.quotes.size.toString()+ "  Records"
            myAdapter = MainAdapter(it.quotes,this)
            myRecyclerView.adapter = myAdapter
            myRecyclerView.layoutManager = LinearLayoutManager(this)
        })
    }
}