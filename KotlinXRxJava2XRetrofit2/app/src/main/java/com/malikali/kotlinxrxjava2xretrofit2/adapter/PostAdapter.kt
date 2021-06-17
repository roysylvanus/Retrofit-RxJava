package com.malikali.kotlinxrxjava2xretrofit2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.malikali.kotlinxrxjava2xretrofit2.R
import com.malikali.kotlinxrxjava2xretrofit2.data.Post
import com.malikali.kotlinxrxjava2xretrofit2.databinding.PostLayoutBinding
import java.lang.StringBuilder


class PostAdapter(internal var context: Context, internal var postList:List<Post>):RecyclerView.Adapter<PostViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val binding = PostLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       holder.tvAuthor.text = postList[position].userId.toString()
        holder.tvContent.text = StringBuilder(postList[position].body.substring(0,20))
            .append("...").toString()
        holder.tvTitle.text = postList[position].title
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}