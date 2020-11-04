package com.nehal.intervue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nehal.intervue.R
import com.nehal.intervue.model.Mcq

class PostAdapter(private val context:Context, private var postList:ArrayList<Mcq>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
     val post=postList[position]
     holder.body.text= post.question
    }

    override fun getItemCount(): Int =postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val body:TextView=itemView.findViewById(R.id.body)
    }

    fun setPostData(postList: ArrayList<Mcq>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}