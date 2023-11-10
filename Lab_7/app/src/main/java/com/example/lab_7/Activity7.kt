package com.example.lab_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity7 : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val fragmentContainerId = R.id.fragmentContainer
    private var stackDepth = 0
    private var numberAddedPages = 0
    private var numberDeletedPages = 0
    private var fragmentText = "Page"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7)

        val backButton = findViewById<Button>(R.id.buttonBack)
        val forwardButton = findViewById<Button>(R.id.buttonForward)
        val stackDepthTextView = findViewById<TextView>(R.id.textStack)
        val AddedPagesTextView = findViewById<TextView>(R.id.textAddPages)
        val DeletedPagesTextView = findViewById<TextView>(R.id.textDeletePages)

        backButton.setOnClickListener {
            if (stackDepth > 0) {
                fragmentManager.popBackStack()
                stackDepth--
                stackDepthTextView.text = "Глубина стека: $stackDepth"
                numberDeletedPages++;
                DeletedPagesTextView.text = "Удалённые страницы: $numberDeletedPages"
            }
        }

        forwardButton.setOnClickListener {
            val fragment = ExampleFragment(fragmentText + " " + (stackDepth + 1).toString()) // Здесь создайте ваш фрагмент
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(fragmentContainerId, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
            stackDepth++
            stackDepthTextView.text = "Глубина стека: $stackDepth"
            numberAddedPages++
            AddedPagesTextView.text = "Добавленные страницы: $numberAddedPages"

        }
    }
}