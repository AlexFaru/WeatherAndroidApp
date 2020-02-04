package com.example.weaderappk.Data.net


import com.example.weatherappk.Data.Model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DarkSkyAPI {

    @GET("forecast/{api_key}/{latitude},{longitude}")
    fun getWeather(
            @Path("api_key")api_key: String,
            @Path("latitude") latitude: String,
            @Path("longitude") longitude: String
    ): Call<Weather>
}