package com.example.lab6

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class Task_7 : AppCompatActivity() {

    private lateinit var editText: EditText;
    private  lateinit var switchBox: Switch;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_7)

        editText = findViewById(R.id.editTextText)
        switchBox = findViewById(R.id.switch1)

        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

        // Получение значения из SharedPreferences
        val savedText = sharedPreferences.getString("text", "")
        val isChecked = sharedPreferences.getBoolean("isChecked", false)

        // Установка значений в представления
        editText.setText(savedText)
        switchBox.isChecked = isChecked

        // Сохранение значений в SharedPreferences
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                sharedPreferences.edit().putString("text", s.toString()).apply()
            }
        });

        switchBox.setOnCheckedChangeListener  { _, isChecked ->
            sharedPreferences.edit().putBoolean("isChecked", isChecked).apply()
        }
    }
}