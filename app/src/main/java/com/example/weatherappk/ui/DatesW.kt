package com.example.weatherappk.ui

import android.text.format.DateFormat
import java.util.*

fun convertTime(time: Int, format: String): String{
    val cal = Calendar.getInstance(Locale.getDefault())
    cal.timeInMillis = (time*1000L)
    val date = DateFormat.format(format, cal).toString().capitalize()
    return date
}