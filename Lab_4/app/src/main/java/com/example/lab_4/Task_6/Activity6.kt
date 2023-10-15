package com.example.lab_4.Task_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import com.example.lab_4.R

data class TaskList(val name: String, val tasks: List<String>)


class Activity6 : AppCompatActivity() {

    private lateinit var expandList: ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_6)

        expandList = findViewById(R.id.expandableListView);

        // Создайте список дел (группы и их задачи)
        val taskLists = listOf(
            TaskList("01.10.2023", listOf("Задача 1", "Задача 2", "Задача 3")),
            TaskList("15.10.2023", listOf("Задача 4", "Задача 5")),
            TaskList("25.10.2023", listOf("Задача 6", "Задача 7", "Задача 8"))
        )

        val adapter = TaskListAdapter(taskLists)
        expandList.setAdapter(adapter)
    }

}