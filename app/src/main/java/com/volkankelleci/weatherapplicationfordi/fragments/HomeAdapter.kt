package com.volkankelleci.weatherapplicationfordi.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.model.WeatherData
import com.volkankelleci.weatherapplicationfordi.databinding.HomeRawBinding

class HomeAdapter(private var weatherList : ArrayList<WeatherData>, private val listener : Listener) : RecyclerView.Adapter<HomeAdapter.RowHolder>() {

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
        return weatherList.size

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val weathers=weatherList[position]
        holder.binding.sayHello.text=weathers.current.toString()


    }


}