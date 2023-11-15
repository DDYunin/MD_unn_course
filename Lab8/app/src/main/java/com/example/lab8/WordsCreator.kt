package com.example.lab8

class WordsCreator {
    private val words = ArrayList<String>()
    private var vowelsWordsCount = 0;

    fun getList() = words;

    fun getWordsCount() = vowelsWordsCount;

    private fun isMoreVowels(word: String, add: Boolean) {
        var numberVowels = 0;
        var numberConsonants = 0;

        val vowelsLetters = arrayOf("a", "e", "i", "o", "u", "а", "я", "у", "ю", "о", "е", "ё", "э", "и", "ы");

        for (letter in word) {
            if (vowelsLetters.contains(letter.toString())) {
                numberVowels++;
            } else {
                numberConsonants++;
            }
        }

        if (add) {
            if (numberVowels > numberConsonants) {
                vowelsWordsCount++;
            }
        } else {

            if (numberVowels > numberConsonants) {
                vowelsWordsCount--;
            }
        }

    }

    fun addWord(word: String) {
        if (word == "") {
            return
        }

        isMoreVowels(word, true)

        if (words.size == 0) {
            words.add(word.lowercase().replaceFirstChar(Char::uppercase))
        } else {
            words.add(word.lowercase())
        }
    }

    fun removeWord() {
        if (words.size != 0) {
            isMoreVowels(words.last(), false);
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