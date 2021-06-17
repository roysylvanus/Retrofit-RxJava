package com.malikali.kotlinxrxjava2xretrofit2.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.malikali.kotlinxrxjava2xretrofit2.databinding.PostLayoutBinding

class PostViewHolder(binding: PostLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    val tvAuthor = binding.tvAuthor
    val tvTitle = binding.tvTitle
    val tvContent = binding.tvContent
}