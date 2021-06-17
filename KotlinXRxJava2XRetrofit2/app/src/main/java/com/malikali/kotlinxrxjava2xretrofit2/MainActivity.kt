package com.malikali.kotlinxrxjava2xretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.malikali.kotlinxrxjava2xretrofit2.adapter.PostAdapter
import com.malikali.kotlinxrxjava2xretrofit2.data.Post
import com.malikali.kotlinxrxjava2xretrofit2.databinding.ActivityMainBinding
import com.malikali.kotlinxrxjava2xretrofit2.retrofit.MyApi
import com.malikali.kotlinxrxjava2xretrofit2.retrofit.RetrofitClient
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi: MyApi
     internal var compositeDisposable: CompositeDisposable? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init Api
        val retrofit = RetrofitClient.instance
        jsonApi = retrofit.create(MyApi::class.java)

        //view
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        fetchRecyclerData()

    }

    private fun fetchRecyclerData() {
        compositeDisposable?.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts->displayData(posts)})

    }

    private fun displayData(posts: List<Post>?) {
        val adapter = PostAdapter(this,posts!!)
        adapter.notifyDataSetChanged()
        binding.recyclerView.adapter = adapter



    }
}