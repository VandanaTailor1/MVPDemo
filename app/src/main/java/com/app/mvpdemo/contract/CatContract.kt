package com.app.mvpdemo.contract

interface CatContract {

    interface View {
       fun showLoading()
       fun hideLoading()
       fun onSuccess(type : String , data : Any)
       fun onFailure(message : String)
    }

    interface CatPresenter {
        fun getCat()
    }

}