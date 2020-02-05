package com.example.weatherappk.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.weatherappk.R
import kotlinx.android.synthetic.main.activity_hourly_avtivity.*

class HourlyAvtivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly_avtivity)
        val summary = intent.getStringArrayExtra(MainActivity.HOURLY_SUMMARY)
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,summary)
        listViewHourly.adapter = adapter
    }
}
