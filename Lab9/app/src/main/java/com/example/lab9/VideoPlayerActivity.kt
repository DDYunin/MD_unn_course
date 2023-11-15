package com.example.lab9

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoPlayerActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        videoView = findViewById(R.id.videoView)

        val videoPath = "android.resource://${packageName}/${R.raw.big_buck_bunny}"
        val videoUri = Uri.parse(videoPath)

        // Создаем объект MediaController для управления видеопроигрывателем
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Устанавливаем MediaController для VideoView
        videoView.setMediaController(mediaController)

        // Устанавливаем URI для воспроизведения видео из сети
        videoView.setVideoURI(videoUri)

        // Начинаем воспроизведение видео
        videoView.start()
    }
}