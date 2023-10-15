package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Чтобы переходить от одной activity к другой
        val intentStep1 = Intent(this, FirstStep::class.java)
        val intentStep2 = Intent(this, SecondStep::class.java)
        val intentStep3 = Intent(this, ThirdStep::class.java)
        val intentStep4 = Intent(this, FourStep::class.java)
        val intentStep5 = Intent(this, FiveStep::class.java)
        val intentStep6 = Intent(this, SixStep::class.java)
        val intentStep7 = Intent(this, SevenStep::class.java)
        val intentStep8 = Intent(this, EightStep::class.java)
        val intentStep9 = Intent(this, NineStep::class.java)

        // Кнопки
        val step1: Button = findViewById(R.id.page1);
        val step2: Button = findViewById(R.id.page2);
        val step3: Button = findViewById(R.id.page3)
        val step4: Button = findViewById(R.id.page4)
        val step5: Button = findViewById(R.id.page5)
        val step6: Button = findViewById(R.id.page6)
        val step7: Button = findViewById(R.id.page7)
        val step8: Button = findViewById(R.id.page8)
        val step9: Button = findViewById(R.id.page9)


        // События перехода на страницу
        step1.setOnClickListener {
            startActivity(intentStep1);
        }

        step2.setOnClickListener {
            startActivity(intentStep2);
        }

        step3.setOnClickListener {
            startActivity(intentStep3);
        }

        step4.setOnClickListener {
            startActivity(intentStep4);
        }

        step5.setOnClickListener {
            startActivity(intentStep5);
        }

        step6.setOnClickListener {
            startActivity(intentStep6);
        }

        step7.setOnClickListener {
            startActivity(intentStep7);
        }

        step8.setOnClickListener {
            startActivity(intentStep8);
        }

        step9.setOnClickListener {
            startActivity(intentStep9);
        }

    }
}