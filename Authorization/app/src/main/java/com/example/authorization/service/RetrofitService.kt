package com.example.authorization.service

import com.example.authorization.model.RequestToken
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

object RetrofitService {

    const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getPostApi(): PostApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(PostApi::class.java)
    }
}

interface PostApi {

    @GET("authentication/token/new")
    fun getRequestToken(@Query("api_key") apiKey: String): Call<RequestToken>

    @POST("authentication/token/validate_with_login")
    fun login(@Query("api_key") apiKey: String, @Body body: JsonObject): Call<JsonObject>


    @POST("authentication/session/new")
    fun getSession(@Query("api_key") apiKey: String, @Body body: JsonObject): Call<JsonObject>

}