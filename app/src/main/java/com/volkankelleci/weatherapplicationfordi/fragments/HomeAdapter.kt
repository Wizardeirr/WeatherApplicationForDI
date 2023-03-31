package com.volkankelleci.weatherapplicationfordi.fragments

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.weatherapplicationfordi.data.WeatherData
import com.volkankelleci.weatherapplicationfordi.databinding.HomeRawBinding

class HomeAdapter(private val weatherList : ArrayList<WeatherData>, private val listener : Listener) : RecyclerView.Adapter<HomeAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(weatherData: WeatherData)
    }

    class RowHolder(val binding : HomeRawBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding = HomeRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return weatherList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

    }


}