package com.example.familywidgets

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.VideoView
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
            Toast.makeText(applicationContext, videoView.currentPosition.toString(), Toast.LENGTH_LONG).show()
            videoView.seekTo(videoView.currentPosition * 3)
            videoView.start()
        }
    }

    override fun onStart() {
        super.onStart()
        val videoView = findViewById<VideoView>(R.id.videoView_menu)
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        videoView.start()
    }

}