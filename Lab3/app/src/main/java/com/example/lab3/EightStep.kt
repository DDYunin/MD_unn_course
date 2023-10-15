package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch

class EightStep : AppCompatActivity() {

    private lateinit var switchPage8: Switch;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.step_8)

        switchPage8 = findViewById(R.id.switchPage8);

        switchPage8.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                switchPage8.text = "Включен"
            }else{
                switchPage8.text = "Выключен"
            }
        }

    }
}