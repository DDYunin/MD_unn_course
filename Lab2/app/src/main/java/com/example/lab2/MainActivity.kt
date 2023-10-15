package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Чтобы переходить от одной activity к другой
        val intentStep2 = Intent(this, SecondActivity::class.java)
        val intentStep3 = Intent(this, ThirdActivity::class.java)
        val intentStep4 = Intent(this, FourActivity::class.java)
        val intentStep5 = Intent(this, FiveActivity::class.java)
        val intentStep6 = Intent(this, SixActivity::class.java)
        val intentStep7 = Intent(this, SevenActivity::class.java)
        val intentStep8 = Intent(this, EightActivity::class.java)

        val step2: Button = findViewById(R.id.pageStep2);
        val step3: Button = findViewById(R.id.pageStep3)
        val step4: Button = findViewById(R.id.pageStep4)
        val step5: Button = findViewById(R.id.pageStep5)
        val step6: Button = findViewById(R.id.pageStep6)
        val step7: Button = findViewById(R.id.pageStep7)
        val step8: Button = findViewById(R.id.pageStep8)


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



    }
}