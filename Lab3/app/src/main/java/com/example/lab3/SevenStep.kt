package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class SevenStep : AppCompatActivity() {

    private lateinit var spinnerList: Spinner;
    private lateinit var textSpinnerList: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_7)

        spinnerList = findViewById(R.id.spinnerStep7);
        textSpinnerList= findViewById(R.id.textViewStep7);

        val data = arrayOf("Строка 1", "Строка 2", "Строка 3", "Строка 4")

        // Создаем ArrayAdapter для адаптации данных к Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)

        // Устанавливаем стиль выпадающего списка
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Устанавливаем адаптер для Spinner
        spinnerList.adapter = adapter

        spinnerList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = spinnerList.selectedItem.toString()
                textSpinnerList.text = "Выбранный элемент: $selectedItem"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Метод вызывается, когда ничего не выбрано в Spinner
                textSpinnerList.text = "Выбранный элемент: "
            }
        }
    }
}