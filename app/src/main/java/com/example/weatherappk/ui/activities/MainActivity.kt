package com.example.weatherappk.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.weaderappk.Data.net.DarkSkyClient
import com.example.weatherappk.Data.Model.Currently
import com.example.weatherappk.Data.Model.Weather
import com.example.weatherappk.R
import com.example.weatherappk.ui.convertTime
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.design.indefiniteSnackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    companion object{
        const val HOURLY_SUMMARY = "HOURLY_SUMMARY"
    }
    var hourlySummary: List<String>? = null

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
                displayUI(true)
                displayProgressBar(false)
                if(response.isSuccessful){
                    hourlySummary =
                        response.body()?.hourly?.data?.map{"${convertTime(it.time,"MMM dd, hh:mm")} ${it.summary}"}
                    setUpWidgets(response.body()?.currently)
                }else{
                    displayErrorMessage()
                }
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
        val  intent = Intent(this, DailyActivity::class.java)
        startActivity(intent)
    }
    fun startHourlyActivity(view: View){
        val  intent = Intent(this, HourlyAvtivity::class.java)
        val array = hourlySummary?.toTypedArray()
        intent.putExtra(HOURLY_SUMMARY, array)
        startActivity(intent)
    }
    private fun displayErrorMessage(){
        mainLayout.indefiniteSnackbar(getString(R.string.network), "Ok"){
            getWeather()
        }
    }

    private fun setUpWidgets(currently: Currently?){
        textViewPronostico.text = currently?.summary
        textViewTemp.text = "${currently?.temperature?.roundToInt()}"
        textViewViento.text = getString(R.string.temperature,currently?.precipProbability?.roundToInt())
        imageView.setImageResource( getWeatherIcon(currently?.icon ?: "clear-day"))
        textViewFecha.text = getDateTime()?.capitalize() ?: getString(R.string.NoData)
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
