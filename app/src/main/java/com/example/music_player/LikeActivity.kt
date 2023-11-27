package com.example.music_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class LikeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like)
        setTheme(R.style.noactionbar)
    }
}