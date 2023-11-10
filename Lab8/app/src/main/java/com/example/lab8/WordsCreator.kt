package com.example.lab8

class WordsCreator {
    private val words = ArrayList<String>()

    fun getList() = words;

    fun addWord(word: String) {
        if (word == "") {
            return
        }

        if (words.size == 0) {
            words.add(word.lowercase().replaceFirstChar(Char::uppercase))
        } else {
            words.add(word.lowercase())
        }
    }

    fun removeWord() {
        if (words.size != 0) {
            words.removeLast()
        }
    }

    @Override
    override fun toString(): String {
        val result = StringBuilder()

        for (word in words) {
            if (result.length > 0) {
                result.append(", ") // Добавляем запятую и пробел, если строка не пуста
            }
            result.append(word) // Добавляем текущую строку
        }

        return result.toString()
    }
}