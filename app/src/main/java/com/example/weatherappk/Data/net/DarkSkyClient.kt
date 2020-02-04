package com.example.weaderappk.Data.net


import com.example.weatherappk.Data.Model.Weather
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DarkSkyClient {

    private val  darkSkyApi : DarkSkyAPI

    private const val DARK_SKY_URL = "https://api.darksky.net/"
    private const val API_KEY = "a5a9d483397e4584e8a80853b09b889f"
    private val coordinates = Pair("37.8267", "-122.4233")

    init {
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
                .baseUrl(DARK_SKY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build()

        darkSkyApi = retrofit.create(DarkSkyAPI::class.java)
    }

    fun getWeather(latitude: String = coordinates.first,
                   longitude: String = coordinates.second): Call<Weather>{
        return darkSkyApi.getWeather(API_KEY, latitude, longitude)
    }
}