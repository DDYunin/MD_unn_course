package com.example.lab9.task_2

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab9.R


class Task2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_with_sprites)

        val characterImageView = findViewById<ImageView>(R.id.characterImageView)
        val animationDrawable = characterImageView.drawable as AnimationDrawable
        animationDrawable.start();
    }
}