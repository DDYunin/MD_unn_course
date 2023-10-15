package com.example.lab_4.Task_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_4.R

class SliderAdapter : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private val slideTexts = listOf("Слайд 1", "Слайд 2", "Слайд 3")

    inner class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sliderText: TextView = itemView.findViewById(R.id.slideText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        // Здесь заполняйте элементы слайдера данными из списка
        val text = "Слайд $position"
        holder.sliderText.text = text
    }

    override fun getItemCount(): Int {
        return slideTexts.size
    }
}
