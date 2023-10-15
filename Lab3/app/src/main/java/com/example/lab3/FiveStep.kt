package com.example.lab3

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FiveStep : AppCompatActivity() {
    private lateinit var buttStep5: Button
    private lateinit var dateTextStep5: TextView
    private lateinit var dateTextDiff: TextView
    private val calendar = Calendar.getInstance()
    private val calendarNow = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_5)

        buttStep5 = findViewById(R.id.buttonStep5);
        dateTextStep5 = findViewById(R.id.textViewStep5)
        dateTextDiff = findViewById(R.id.textView2)

        buttStep5.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val selectedDate = calendar.time
                val formattedDate = dateFormat.format(selectedDate)
                dateTextStep5.text = formattedDate
                dateTextDiff.text = "Разница в годах: " + (calendarNow.get(Calendar.YEAR) - calendar.get(Calendar.YEAR))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }
}