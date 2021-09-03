package com.example.authorization.modelview

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.authorization.BuildConfig
import com.example.authorization.model.RequestToken
import com.example.authorization.model.Session
import com.example.authorization.service.RetrofitService
import com.example.authorization.view.WelcomePage
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginViewModel(private val context: Context): ViewModel() {
    private lateinit var requestToken: String
    private lateinit var newRequestToken: String

    fun getToken(email: String, password: String) {
        if(email != "" && password != ""){
        RetrofitService.getPostApi().getRequestToken("4de67cd6e7c4156e8a79804239c1ec34")
            .enqueue(object : Callback<RequestToken> {
                override fun onFailure(call: Call<RequestToken>, t: Throwable) {
                    Toast.makeText(context,"Nooooooo", Toast.LENGTH_SHORT)
                }

                override fun onResponse(
                    call: Call<RequestToken>,
                    response: Response<RequestToken>
                ) {
                    Toast.makeText(context,"Goooooood", Toast.LENGTH_SHORT)

                    if (response.isSuccessful) {
                        requestToken = response.body()?.requestToken!!

                        val body = JsonObject().apply {
                            addProperty("username", email)
                            addProperty("password", password)
                            addProperty("request_token", requestToken)
                        }

                        RetrofitService.getPostApi()
                            .login(BuildConfig.THE_MOVIE_DB_API_TOKEN, body)
                            .enqueue(object : Callback<JsonObject> {
                                override fun onFailure(
                                    call: Call<JsonObject>,
                                    t: Throwable
                                ) {

                                }

                                override fun onResponse(
                                    call: Call<JsonObject>,
                                    response: Response<JsonObject>
                                ) {

                                    if (response.isSuccessful) {

                                        var gson = Gson()
                                        var new_RequestToken = gson.fromJson(
                                            response.body(),
                                            RequestToken::class.java
                                        )
                                        newRequestToken = new_RequestToken.requestToken

                                        RetrofitService.getPostApi()
                                            .getSession(
                                                BuildConfig.THE_MOVIE_DB_API_TOKEN,
                                                body
                                            )
                                            .enqueue(object : Callback<JsonObject> {
                                                override fun onFailure(
                                                    call: Call<JsonObject>,
                                                    t: Throwable
                                                ) {
                                                    Toast.makeText(
                                                        context,
                                                        "fail",
                                                        Toast.LENGTH_SHORT
                                                    ).show()

                                                }

                                                override fun onResponse(
                                                    call: Call<JsonObject>,
                                                    response: Response<JsonObject>
                                                ) {

                                                    if (response.isSuccessful) {
                                                        var session = gson.fromJson(response.body(),
                                                            Session::class.java)
                                                        var sessionId = session.sessionId
                                                        var intent = Intent(context, WelcomePage::class.java)
                                                        intent.putExtra("username",email)
                                                        intent.putExtra("sessionId",sessionId)
                                                        intent.putExtra("token",newRequestToken)
                                                        context.startActivity(intent)
                                                    }

                                                }
                                            })


                                    }

                                }
                            })

                    }

                }
            })
    } else {
        Toast.makeText(context, "Empty email or password", Toast.LENGTH_LONG)
            .show()
    }
    }
}