package com.example.lab6

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.DB.AppDataBase
import com.example.lab6.DB.DataBaseBuilder
import com.example.lab6.DB.EntityTask
import com.example.lab6.DB.RemoveListDBAdapter
import com.example.lab6.SimpleRecyclerList.ItemRectangle
import com.example.lab6.SimpleRecyclerList.RectangleListBuilder

class Task_6 : AppCompatActivity() {

    private lateinit var db : AppDataBase
    private lateinit var adapter : RemoveListDBAdapter
    private val rlist = RectangleListBuilder.build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_6)

        db = DataBaseBuilder().build(this.applicationContext)!!
        adapter = RemoveListDBAdapter()
//        db!!.taskDAO().deleteAll()
        val list = db!!.taskDAO().getAll()
        rlist.getList().clear()

        list.forEach {
            rlist.addRectangle(ItemRectangle(Color.BLACK, Color.WHITE, it.taskTitle.toString()))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycleView);
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    fun onAdd(view: View) {
        val text = findViewById<EditText>(R.id.editTextInput).text.toString()
        findViewById<EditText>(R.id.editTextInput).setText("")
        db!!.taskDAO().insertAll(EntityTask(text))
        rlist.getList().clear()
        db!!.taskDAO().getAll().forEach {
            rlist.addRectangle(ItemRectangle(Color.BLACK, Color.WHITE, it.taskTitle.toString()))
        }

        adapter.notifyDataSetChanged()
    }
}