package com.malikali.kotlinxrxjava2xretrofit2.retrofit

import com.malikali.kotlinxrxjava2xretrofit2.data.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface MyApi {
    @get:GET("posts")
    val posts:Observable<List<Post>>
}