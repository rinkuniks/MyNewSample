package com.nikhil.mynewsample.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.nikhil.mynewsample.R
import com.nikhil.mynewsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.dataProvider = viewModel
        binding.btnLogin.text = "abc"
        binding.btnLogin.setOnClickListener {
            enableLoginDetails()
        }
        oberveDataFromApi()
    }

    fun enableLoginDetails() {
        Log.d(TAG, "enableLoginDetails: 1")
        viewModel.loginApi()
    }

   private fun oberveDataFromApi(){
        viewModel.loginResponseApi.observe(this, Observer {
            Log.d(TAG, "oberveDataFromApi: working${it.data?.name}")
        })
    }
    
}