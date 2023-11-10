package com.example.lab6

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Task_8 : AppCompatActivity() {

    private lateinit var loginField: EditText;
    private lateinit var passwordField: EditText;
    private lateinit var isRemembered: CheckBox;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_8)

        loginField = findViewById(R.id.editTextTextEmailAddress)
        passwordField = findViewById(R.id.editTextTextPassword)
        isRemembered = findViewById(R.id.checkBox)

        val sharedPreferences = getSharedPreferences("FormAutorization", Context.MODE_PRIVATE)

        // Получение значения из SharedPreferences
        val savedLoginText = sharedPreferences.getString("login", "")
        val savedPasswordText = sharedPreferences.getString("password", "")
        val isChecked = sharedPreferences.getBoolean("isChecked", false)

        // Установка значений в представления
        loginField.setText(savedLoginText)
        passwordField.setText(savedPasswordText)
        isRemembered.isChecked = isChecked

        isRemembered.setOnCheckedChangeListener  { _, isChecked ->
            Log.i("Checked:", isChecked.toString());
            // Сохранить значение

            sharedPreferences.edit().putBoolean("isChecked", isChecked).apply()
            // Сохранить значение, которое находится в loginField и passwordField
            if (isChecked) {
                sharedPreferences.edit().putString("login", loginField.text.toString()).apply()
                sharedPreferences.edit().putString("password", passwordField.text.toString()).apply()
            } else {
                sharedPreferences.edit().putString("login", "").apply()
                sharedPreferences.edit().putString("password", "").apply()
            }


        }
    }
}