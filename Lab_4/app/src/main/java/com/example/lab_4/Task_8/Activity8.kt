package com.example.lab_4.Task_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.lab_4.R

class Activity8 : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var sliderAdapter: SliderAdapter // Создайте свой адаптер

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_8)

        viewPager = findViewById(R.id.viewPager)
        sliderAdapter = SliderAdapter() // Создайте свой адаптер (см. ниже)

        viewPager.adapter = sliderAdapter
    }

}