package com.example.lab6

import android.graphics.Color
import android.os.Bundle
import android.os.StrictMode
import android.util.Xml
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.SimpleRecyclerList.ItemRectangle
import com.example.lab6.SimpleRecyclerList.RectangleListBuilder
import kotlinx.coroutines.launch
import org.xmlpull.v1.XmlPullParser
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.text.NumberFormat
import java.util.Locale

class Task_3 : AppCompatActivity() {

    private val link : String = "http://www.cbr.ru/scripts/XML_daily.asp"
    private val list = RectangleListBuilder.build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_4)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        list.getList().clear()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = RemoveListAdapter()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                (recyclerView.adapter as RemoveListAdapter).notifyDataSetChanged()
                parseResponse(link)
            }
        }

    }

    private fun parseResponse(url : String) {
        // Объект используется для разбора XML-данных.
        val parser = Xml.newPullParser()
        var stream: InputStream? = null
        val nf: NumberFormat = NumberFormat.getInstance(Locale.FRANCE)
        try {
            // Затем устанавливается соединение с указанным URL и получается InputStream для получения данных.
            stream = URL(url).openConnection().getInputStream()
            // XML-парсер parser настраивается на работу с данными из stream.
            parser.setInput(stream, null)
            var eventType = parser.eventType
            var done = false
            var item: Money? = null
            // Парсер начинает обработку XML-данных в цикле, проходя через каждое событие (event) в XML-документе.
            while (eventType != XmlPullParser.END_DOCUMENT && !done) {
                var name: String? = null
                when (eventType) {
                    XmlPullParser.START_DOCUMENT -> {}
                    XmlPullParser.START_TAG -> {
                        name = parser.name
                        if (name.contains(
                                "VALUTE",
                                ignoreCase = true
                            )
                        ) {
                            item = Money()
                        } else if (item != null) {
                            if (name.equals("NAME", ignoreCase = true)) {
                                item.name = (parser.nextText().trim())
                            } else if (name.equals("VALUE", ignoreCase = true)) {
                                item.currency = nf.parse((parser.nextText().trim())).toDouble()
                            }
                        }
                    }
                    XmlPullParser.END_TAG -> {
                        name = parser.name
                        if (name.equals(
                                "VALUTE",
                                ignoreCase = true
                            ) && item != null
                        ) {
                            list.addRectangle(
                                ItemRectangle(
                                    Color.BLACK, Color.WHITE,
                                "${item.name} \n ${item.currency}"
                            )
                            )
                        } else if (name.contains(
                                "ValCurs",
                                ignoreCase = true
                            )
                        ) {
                            done = true
                        }
                    }
                }
                eventType = parser.next()
            }
        } catch (e: Exception) {
            throw RuntimeException(e)
        } finally {
            if (stream != null) {
                try {
                    stream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
    class Money (var name : String = "", var currency: Double = 0.0)
}