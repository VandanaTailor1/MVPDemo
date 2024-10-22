package com.app.mvpdemo.presenter

import com.app.mvpdemo.contract.CatContract
import com.app.mvpdemo.model.CatResponse
import com.app.mvpdemo.network.ApiService
import com.app.mvpdemo.network.RetrofitModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatPresenter(val view : CatContract.View) : CatContract.CatPresenter {

    private var apiService: ApiService = RetrofitModule.retrofit.create(ApiService::class.java)

    override fun getCat() {
     view.showLoading()
        apiService.getCatData().enqueue(object : Callback<CatResponse>{
            override fun onResponse(call: Call<CatResponse>, response: Response<CatResponse>) {
                view.hideLoading()
                view.onSuccess("Cat",response)
            }

            override fun onFailure(p0: Call<CatResponse>, p1: Throwable) {
                view.hideLoading()
                view.onFailure(p0.toString())
            }

        })
    }





}