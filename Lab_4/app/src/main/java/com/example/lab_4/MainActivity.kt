package com.example.lab_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.lab_4.Task_1.Activity1
import com.example.lab_4.Task_10.Activity10
import com.example.lab_4.Task_11.Activity11
import com.example.lab_4.Task_2.Activity2
import com.example.lab_4.Task_6.Activity6
import com.example.lab_4.Task_8.Activity8
import com.example.lab_4.Task_9.Activity9

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Чтобы переходить от одной activity к другой
        val intentStep1 = Intent(this, Activity1::class.java)
        val intentStep2 = Intent(this, Activity2::class.java)
        val intentStep3 = Intent(this, Activity3::class.java)
        val intentStep4 = Intent(this, Activity4::class.java)
        val intentStep5 = Intent(this, Activity5::class.java)
        val intentStep6 = Intent(this, Activity6::class.java)
        val intentStep7 = Intent(this, Activity7::class.java)
        val intentStep8 = Intent(this, Activity8::class.java)
        val intentStep9 = Intent(this, Activity9::class.java)
        val intentStep10 = Intent(this, Activity10::class.java)
        val intentStep11 = Intent(this, Activity11::class.java)

        // Кнопки
        val step1: Button = findViewById(R.id.button1)
        val step2: Button = findViewById(R.id.button2)
        val step3: Button = findViewById(R.id.button3)
        val step4: Button = findViewById(R.id.button4)
        val step5: Button = findViewById(R.id.button5)
        val step6: Button = findViewById(R.id.button6)
        val step7: Button = findViewById(R.id.button7)
        val step8: Button = findViewById(R.id.button8)
        val step9: Button = findViewById(R.id.button9)
        val step10: Button = findViewById(R.id.button10)
        val step11: Button = findViewById(R.id.button11)

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

        step10.setOnClickListener {
            startActivity(intentStep10);
        }

        step11.setOnClickListener {
            startActivity(intentStep11);
        }
    }
}