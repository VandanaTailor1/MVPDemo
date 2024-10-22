package com.app.mvpdemo.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.mvpdemo.contract.CatContract
import com.app.mvpdemo.databinding.ActivityMainBinding
import com.app.mvpdemo.presenter.CatPresenter

class MainActivity : AppCompatActivity() , CatContract.View {
    private lateinit var binding: ActivityMainBinding

    private lateinit var catPresenter : CatPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        catPresenter=CatPresenter(this)

        binding.btnSubmit.setOnClickListener {
            catPresenter.getCat()
        }


    }

    override fun showLoading() {
        binding.progress.visibility= View.VISIBLE
    }

    override fun hideLoading() {
        binding.progress.visibility= View.GONE
    }

    override fun onSuccess(type: String, data: Any) {
        Log.d("dataprintingggg", "onSuccess: $data")
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}