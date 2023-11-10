package com.example.lab8

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_activity)

        val textValue: TextView = findViewById(R.id.counterValueText);
        val buttonAdd: Button = findViewById(R.id.buttonAdd);
        val buttonReset: Button = findViewById(R.id.buttonReset);


        val counter: Counter = Counter(1);

        textValue.text = counter.getValue().toString()

        buttonAdd.setOnClickListener {
            counter.incrementValue();
            textValue.text = counter.getValue().toString()
        }

        buttonReset.setOnClickListener {
            counter.resetValue()
            textValue.text = counter.getValue().toString()
        }


    }
}