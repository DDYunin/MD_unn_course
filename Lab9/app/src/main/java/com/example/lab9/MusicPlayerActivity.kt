package com.example.lab9

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MusicPlayerActivity: AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var textViewSongName: TextView
    private lateinit var buttonPlayPause: Button
    private lateinit var buttonStop: Button
    private lateinit var buttonNext: Button
    private lateinit var buttonPrevious: Button

    private val songs = listOf(
        R.raw.kimono,
        R.raw.uhodya_gasite_vseh,
        R.raw.starichok
    )

    private var currentSongIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        // Создаём плеер с текущим количеством треков
        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex])
        // Находим нужные элементы
        textViewSongName = findViewById(R.id.textViewSongName)
        buttonPlayPause = findViewById(R.id.buttonPlayPause)
        buttonStop = findViewById(R.id.buttonStop)
        buttonNext = findViewById(R.id.buttonNext)
        buttonPrevious = findViewById(R.id.buttonPrevious)

        textViewSongName.text = "Song ${currentSongIndex + 1}"

        buttonPlayPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                pauseSong()
            } else {
                playSong()
            }
        }

        buttonStop.setOnClickListener {
            stopSong()
        }

        buttonNext.setOnClickListener {
            nextSong()
        }

        buttonPrevious.setOnClickListener {
            previousSong()
        }
    }

    private fun playSong() {
        mediaPlayer.start()
        buttonPlayPause.text = "Pause"
    }

    private fun pauseSong() {
        mediaPlayer.pause()
        buttonPlayPause.text = "Play"
    }

    private fun stopSong() {
        mediaPlayer.stop()
        mediaPlayer = MediaPlayer.create(this, songs[currentSongIndex])
        buttonPlayPause.text = "Play"
    }

    private fun nextSong() {
        currentSongIndex = (currentSongIndex + 1) % songs.size
        changeSong()
    }

    private fun previousSong() {
        currentSongIndex = if (currentSongIndex > 0) {
            currentSongIndex - 1
        } else {
            songs.size - 1
        }
        changeSong()
    }

    private fun changeSong() {
        stopSong()
        textViewSongName.text = "Song ${currentSongIndex + 1}"
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}