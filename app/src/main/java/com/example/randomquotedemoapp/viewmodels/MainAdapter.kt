package com.example.randomquotedemoapp.viewmodels

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomquotedemoapp.R
import com.example.randomquotedemoapp.models.Quote

class MainAdapter(var newsArrayList: List<Quote>,var context: Activity)
    : RecyclerView.Adapter<MainAdapter.MyViewHolder>(){

    //private lateinit var myListener: intItemClickListener

    /*interface intItemClickListener{
        fun onItemClicking(position: Int)
    }*/

    /*fun setOnItemClickListener(listener: intItemClickListener){
        myListener=listener
    }*/

    //Creates new view instance when layout manager fails to find one
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate( R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    //Populate items with data
    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.hQuote.text = currentItem.quote.trim()
        holder.hAuthor.text = "Author: "+ currentItem.author
    }

    //Count of list items in the
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    //It holds the views so that views are not created everytime
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val hQuote = itemView.findViewById<TextView>(R.id.quote)
        val hAuthor = itemView.findViewById<TextView>(R.id.author)
        /*init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }*/
        }
    }

