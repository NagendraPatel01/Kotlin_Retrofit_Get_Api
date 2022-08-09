package com.dw.kotlinretrofit.networking

import com.dw.kotlinretrofit.model.Animal
import com.dw.kotlinretrofit.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getRandomAnimal(): Call<List<Animal>>

    @GET("posts/1/comments")
    fun getdata(): Call<List<User>>

}