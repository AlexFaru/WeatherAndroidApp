

package com.example.weatherappk.Data.Model

data class Minutely(

    val summary: String,
    val icon: String,
    val data: List<Data>
)