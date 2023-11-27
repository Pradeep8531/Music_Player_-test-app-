package com.example.music_player

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class player1Activity : AppCompatActivity() {
    lateinit var runnable: Runnable
    private var handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player1)



        val name = intent.getStringExtra("name")
        val lastMessage  = intent.getStringExtra("lastMessage ")
        val LastmessageTime = intent.getStringExtra("LastmessageTime")
        val imageId = intent.getIntExtra("imageId",R.drawable.play)
        val songs = intent.getIntExtra("songs",R.raw.wdta)


        val songn = findViewById<TextView>(R.id.songn)
        val descri = findViewById<TextView>(R.id.descri)
        val songpc = findViewById<ImageView>(R.id.songpc)


        songn.text = name
        descri.text = lastMessage
        songpc.setImageResource(imageId)



        val mediaplayer : MediaPlayer = MediaPlayer.create(this, songs)





        val seekbar : SeekBar = findViewById(R.id.seekbar)

        seekbar.progress = 0

        val play_btn : ImageButton = findViewById(R.id.play_btn)
        play_btn.setOnClickListener{
            if(!mediaplayer.isPlaying){
                mediaplayer.start()
                play_btn.setImageResource(R.drawable.pause)}
            else{
                mediaplayer.pause()
                play_btn.setImageResource(R.drawable.play)
            }
        }
        seekbar.max = mediaplayer.duration
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if(changed){
                    mediaplayer.seekTo(pos)
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        runnable = Runnable {
            seekbar.progress=mediaplayer.currentPosition
            handler.postDelayed(runnable,1000)

        }
        handler.postDelayed(runnable,1000)
        mediaplayer.setOnCompletionListener {
            play_btn.setImageResource(R.drawable.play)
            seekbar.progress=0
        }


    }


}