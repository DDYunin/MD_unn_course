package com.example.lab_4.Task_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lab_4.R

class BottomFragment: Fragment(R.layout.fragment_second_task_bottom) {

    private lateinit var buttonBack: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonBack = view.findViewById(R.id.bnBackSecond)
        buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack("FirstFragment", 0)
        }
    }
}