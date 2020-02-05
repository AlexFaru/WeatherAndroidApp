package com.example.weatherappk.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappk.Data.Model.Data
import com.example.weatherappk.R
import com.example.weatherappk.ui.convertTime
import kotlinx.android.synthetic.main.list_item.view.*

class DailyAdapter(private val data: List<Data>?) : RecyclerView.Adapter<DailyAdapter.DailyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return DailyHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: DailyHolder, position: Int) {
        data?.let{
            holder.bind(it[position])
        }
    }

    inner class DailyHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(data: Data) = with(view){
            textViewSummary.text = data.summary
            textViewDate.text = convertTime(data.time, "MMMM dd")
        }
    }
}