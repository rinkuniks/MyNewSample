package com.nikhil.mynewsample.screen.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.nikhil.mynewsample.R
import com.nikhil.mynewsample.databinding.ActivityLoginBinding
import com.nikhil.mynewsample.screen.register.RegisterActivity
import com.nikhil.mynewsample.screen.register.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding
    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.dataProvider = viewModel
        binding.btnLogin.text = "Login"
        binding.btnLogin.setOnClickListener {
            enableLoginDetails()
        }
        binding.tvCreateAccount.setOnClickListener {
            val i = Intent(baseContext, RegisterActivity::class.java)
            startActivity(i)
        }
    }

    fun enableLoginDetails() {
        Log.d(TAG, "enableLoginDetails: 1")
        viewModel.loginApi()
    }

}