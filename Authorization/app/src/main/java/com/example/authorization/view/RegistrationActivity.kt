package com.example.authorization.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.authorization.R

class RegistrationActivity : AppCompatActivity() {
    lateinit var register: Button
    lateinit var backLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        register = findViewById(R.id.registration)
        backLogin = findViewById(R.id.backToLogin)

        register.setOnClickListener {
            val intent = Intent(this@RegistrationActivity, MainActivity::class.java)
            startActivity(intent)
        }
        backLogin.setOnClickListener {
            val intent = Intent(this@RegistrationActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
