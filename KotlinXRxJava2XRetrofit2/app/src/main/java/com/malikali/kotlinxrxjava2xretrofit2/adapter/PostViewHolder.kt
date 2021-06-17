package com.malikali.kotlinxrxjava2xretrofit2.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_layout.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvAuthor = itemView.tvAuthor
    val tvTitle = itemView.tvTitle
    val tvContent = itemView.tvContent
}