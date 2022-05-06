package com.example.familywidgets

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Activity_menu : AppCompatActivity() {

    var stopPosition : Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn_image_web = findViewById<ImageView>(R.id.img_web_view_image_view)
        val btn_calendar_progress = findViewById<ImageView>(R.id.img_calendar_progress)
        val btn_image_gallery = findViewById<ImageView>(R.id.btn_image_gallery)
        val btn_frecuent_questions = findViewById<ImageView>(R.id.btn_frecuent_questions)

        btn_image_web.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_calendar_progress.setOnClickListener {
            val intent = Intent(this, Activity_second::class.java)
            startActivity(intent)
        }

        btn_image_gallery.setOnClickListener {
            val intent = Intent(this, Activity_gallery::class.java)
            startActivity(intent)
        }

        btn_frecuent_questions.setOnClickListener {
            val intent = Intent(this, Activity_questions::class.java)
            startActivity(intent)
        }

        //-------------------------------------VIDEO VIEW--------------------------------------------
        val videoView = findViewById<VideoView>(R.id.videoView_menu)
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        videoView.start()



        val btn_pause = findViewById<Button>(R.id.btn_pause)
        btn_pause.setOnClickListener {
            stopPosition = videoView.currentPosition
            videoView.pause()
        }

        val btn_start = findViewById<Button>(R.id.btn_play)
            btn_start.setOnClickListener {
            videoView.start()
        }

        //---------------------------------SEEKBAR NORMAL-----------------------------------------------------
        val seekBarNormal= findViewById<SeekBar>(R.id.seekbar_video)
        seekBarNormal.min = 0
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            seekBarNormal.max = videoView.duration
        }

        videoView.start()

        seekBarNormal?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                videoView.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })


    }

    override fun onStart() {
        super.onStart()
        val videoView = findViewById<VideoView>(R.id.videoView_menu)
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        videoView.start()
    }

}