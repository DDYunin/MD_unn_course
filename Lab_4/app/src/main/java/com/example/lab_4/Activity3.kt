package com.example.lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.Stack

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val text: TextView = findViewById(R.id.textAfterDialog3);
        val button: Button = findViewById(R.id.buttonOpenDialog3);

        button.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Введите текст")

            val input = EditText(this)
            alertDialogBuilder.setView(input)

            alertDialogBuilder.setPositiveButton("ОК") { dialog, which ->
                val enteredText = input.text.toString()
                text.setText(enteredText)
            }

            alertDialogBuilder.setNegativeButton("Отмена") { dialog, which ->
                dialog.cancel()
            }

            alertDialogBuilder.show()
        }
    }

}