package com.app.mvpdemo.network

import com.app.mvpdemo.model.CatResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("fact")
    fun getCatData(): Call<CatResponse>

}
