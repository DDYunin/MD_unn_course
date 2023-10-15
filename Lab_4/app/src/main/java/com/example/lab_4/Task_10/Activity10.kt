package com.example.lab_4.Task_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lab_4.R


class Activity10: AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_10)

        listView = findViewById(R.id.listViewTask10)
        textView = findViewById(R.id.textViewTask10)


        val items = arrayOf("Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        // Настройка обработчика долгого нажатия на элемент списка
        listView.setOnItemLongClickListener { _, _, position, _ ->
            val selectedItem = listView.getItemAtPosition(position).toString()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Выберите действие")
            builder.setItems(arrayOf("Редактировать", "Удалить", "Добавить")) { _, which ->
                when (which) {
                    0 -> {
                        // Обработка выбора "Редактировать"
                        val message = "Вы выбрали редактирование элемента \"$selectedItem\" (позиция: $position)"
                        textView.text = message
                    }
                    1 -> {
                        // Обработка выбора "Удалить"
                        val message = "Вы выбрали удаление элемента \"$selectedItem\" (позиция: $position)"
                        textView.text = message
                    }
                    2 -> {
                        // Обработка выбора "Удалить"
                        val message = "Вы выбрали добавление элемента \"$selectedItem\" (позиция: $position)"
                        textView.text = message
                    }
                }
            }
            builder.show()
            true
        }
    }
}