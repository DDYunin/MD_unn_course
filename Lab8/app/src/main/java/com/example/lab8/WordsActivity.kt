package com.example.lab8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class WordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.words_activity)

        val wordsCreator: WordsCreator = WordsCreator();

        val inputText: EditText = findViewById(R.id.editTextText);
        val addWordButton: Button = findViewById(R.id.button)
        val deleteWordButton: Button = findViewById(R.id.button2)
        val textWords: TextView = findViewById(R.id.textView)
        val wordsWithVowels: TextView = findViewById(R.id.wordsWithVowels);

        val mainText = "Количество слов с большим числом гласных: ";
        wordsWithVowels.text = mainText + wordsCreator.getWordsCount().toString();


        addWordButton.setOnClickListener {
            wordsCreator.addWord(inputText.text.toString())
            textWords.text = wordsCreator.toString()
            inputText.setText("")
            wordsWithVowels.text = mainText + wordsCreator.getWordsCount().toString()
        }

        deleteWordButton.setOnClickListener {
            wordsCreator.removeWord()
            textWords.text = wordsCreator.toString()
            wordsWithVowels.text = mainText + wordsCreator.getWordsCount().toString()
        }

    }
}