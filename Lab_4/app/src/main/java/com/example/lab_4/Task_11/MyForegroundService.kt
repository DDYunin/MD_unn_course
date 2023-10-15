package com.example.lab_4.Task_11

import android.app.*
import android.content.Intent
import android.os.IBinder
import android.widget.RemoteViews
import android.os.Build
import android.os.CountDownTimer
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.lab_4.R

class MyForegroundService : Service() {
    private var counter = 0
    private lateinit var notification: Notification
    private lateinit var notificationLayout: RemoteViews

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        notificationLayout = RemoteViews(packageName, R.layout.foreground_service_layout)
        notificationLayout.setTextViewText(R.id.textView, counter.toString())

        val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                "channel_id",
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        } else {
            null
        }

        val notificationBuilder = NotificationCompat.Builder(this, "channel_id")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setCustomContentView(notificationLayout)

        if (channel != null) {
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }

        notification = notificationBuilder.build()

        startForeground(1, notification)

        // Обработка нажатий кнопок
        val increaseIntent = Intent(this, MyForegroundService::class.java)
        increaseIntent.action = "INCREASE"
        val increasePendingIntent = PendingIntent.getService(this, 0, increaseIntent,
            PendingIntent.FLAG_MUTABLE)
        notificationLayout.setOnClickPendingIntent(R.id.increaseButton, increasePendingIntent)

        val resetIntent = Intent(this, MyForegroundService::class.java)
        resetIntent.action = "RESET"
        val resetPendingIntent = PendingIntent.getService(this, 1, resetIntent,
            PendingIntent.FLAG_MUTABLE)
        notificationLayout.setOnClickPendingIntent(R.id.resetButton, resetPendingIntent)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Clean up resources when the service is stopped
        stopForeground(true)
        stopSelf()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)

        when (intent?.action) {
            "INCREASE" -> {
                counter++
                Log.d("MyForegroundService", "Увеличено значение: $counter")
            }
            "RESET" -> {
                counter = 0
                Log.d("MyForegroundService", "Счетчик сброшен")
            }
            else -> {
                Log.d("MyForegroundService", "Действие не определено: ${intent?.action}")
            }
        }

        notificationLayout.setTextViewText(R.id.textView, counter.toString())

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, notification)
    }
}

