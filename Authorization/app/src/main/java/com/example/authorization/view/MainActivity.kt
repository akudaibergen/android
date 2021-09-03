package com.example.authorization.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.authorization.*
import com.example.authorization.model.RequestToken
import com.example.authorization.model.Session
import com.example.authorization.modelview.LoginViewModel
import com.example.authorization.modelview.ViewModelProviderFactory
import com.example.authorization.service.RetrofitService
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var register: Button
    lateinit var requestToken: String
    lateinit var newRequestToken: String
    lateinit var emailValue: String
    lateinit var passwordValue: String
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        val viewModelProviderFactory = ViewModelProviderFactory(context = this)

        loginViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(LoginViewModel::class.java)

        login.setOnClickListener {
            loginViewModel.getToken(email.text.toString(), password.text.toString())
        }

        register.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }


    private fun bindView() {
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)
        register = findViewById(R.id.register)
    }
}
