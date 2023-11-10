package com.example.lab6

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.SimpleRecyclerList.ItemRectangle
import com.example.lab6.SimpleRecyclerList.RectangleListBuilder

class Task_2 : AppCompatActivity() {
    private var counter : Int = 0
    private var adapter = RemoveListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_2)

        // Использую лист, который был создан однажды
        val list = RectangleListBuilder.build()
        list.getList().clear()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTask2);
        // Менеджер макета в RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    fun onAddItem(view: View) {
        val list = RectangleListBuilder.build()
        list.addRectangle(ItemRectangle(Color.BLACK, Color.WHITE, "Элемент ${counter++}"))
        adapter.notifyDataSetChanged()
    }
}