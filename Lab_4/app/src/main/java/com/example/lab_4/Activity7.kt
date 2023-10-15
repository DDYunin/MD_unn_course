package com.example.lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Activity7 : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7)

        webView = findViewById(R.id.webView)

        // Настройка WebView
        val webSettings = webView.settings
        // Включение поддержки JavaScript
        webSettings.javaScriptEnabled = true

        // Настройка клиента WebView
        webView.webViewClient = WebViewClient()


        // Загрузка вашего любимого сайта
        val url = "https://learn.javascript.ru/"
        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        // Проверка на наличие страниц в истории и возможность вернуться назад
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}