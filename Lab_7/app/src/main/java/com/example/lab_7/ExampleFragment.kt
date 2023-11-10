package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lab_7.R.*

class ExampleFragment(private val fragmentText: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Создаем макет для фрагмента
        val view = inflater.inflate(layout.fragment_example, container, false)

        // Находим TextView в макете фрагмента
        val textView = view.findViewById<TextView>(R.id.textViewTask1)

        // Устанавливаем текст, который будет отображаться на странице
        textView.text = fragmentText

        return view
    }
}
