package com.example.weatherappk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.weaderappk.Data.net.DarkSkyClient
import com.example.weatherappk.Data.Model.Currently
import com.example.weatherappk.Data.Model.Weather
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.indefiniteSnackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWeather()
    }

    private fun getWeather(){
        displayUI(false)
        displayProgressBar(true)
        DarkSkyClient.getWeather().enqueue(object : Callback<Weather>{
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                displayErrorMessage()
            }
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                setUpWidgets(response.body()?.currently)
                displayUI(true)
                displayProgressBar(false)
            }
        })
    }

    private fun displayUI(visible: Boolean){
        textViewFecha.visibility = if(visible) View.VISIBLE else View.GONE
        textViewViento.visibility = if(visible) View.VISIBLE else View.GONE
        textViewTemp.visibility = if(visible) View.VISIBLE else View.GONE
        textViewPronostico.visibility = if(visible) View.VISIBLE else View.GONE
        imageView.visibility = if(visible) View.VISIBLE else View.GONE
        buttonDaily.visibility = if(visible) View.VISIBLE else View.GONE
        buttonHourly.visibility = if(visible) View.VISIBLE else View.GONE
    }

    private fun displayProgressBar(visible: Boolean){
        progressBar.visibility = if(visible) View.VISIBLE else View.GONE
    }

    fun startDailyActivity(view: View){
        val  intent = Intent(this, DailyActivity::class.java);
        startActivity(intent);
    }
    fun startHourlyActivity(view: View){
        val  intent = Intent(this, HourlyAvtivity::class.java)
        startActivity(intent);
    }
    private fun displayErrorMessage(){
        mainLayout.indefiniteSnackbar("Network Error. Try Again?", "Ok"){
            getWeather()
        }
    }

    private fun setUpWidgets(currently: Currently?){
        textViewPronostico.text = currently?.summary
        textViewTemp.text = "${currently?.temperature?.roundToInt()}°F"
        textViewViento.text = "${currently?.precipProbability?.roundToInt()}%"
        imageView.setImageResource( getWeatherIcon(currently?.icon ?: "clear-day"))
        textViewFecha.text = getDateTime()?.capitalize() ?: "No Data"
    }
    private fun getDateTime(): String?{
        return try {

            val simpleDateFormat = SimpleDateFormat("MMMM d", Locale.getDefault())
            val date = Calendar.getInstance().time
            simpleDateFormat.format(date)
        }catch(e: Exception){
            e.toString()
        }
    }



    private fun getWeatherIcon(iconString: String): Int{
        return when(iconString){
            "clear-day" -> R.drawable.soleado
            "clear-night" -> R.drawable.clearnight
            "rain" -> R.drawable.rain
            "snow" -> R.drawable.snow
            "sleet" -> R.drawable.sleet
            "wind" -> R.drawable.wind
            "fog" -> R.drawable.fog
            "cloudy" -> R.drawable.nublado
            "partly-cloudy-day" -> R.drawable.partlycloudy
            "partly-cloudy-night" -> R.drawable.partlycloudynight
            else -> R.drawable.soleado
        }
    }


}
