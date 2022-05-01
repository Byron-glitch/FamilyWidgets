package com.example.familywidgets

import android.content.Intent
import android.media.session.MediaController
import android.net.Uri
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.VideoView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Activity_three : AppCompatActivity() {

    var stopPosition : Int = 0


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        val progressBarHorizontal = findViewById<ProgressBar>(R.id.progressBarHorizontal)
        progressBarHorizontal.setProgress(10, true)

        val btn_menos_10 = findViewById<Button>(R.id.btn_menos_10)
        btn_menos_10.setOnClickListener {
            progressBarHorizontal.setProgress(progressBarHorizontal.progress - 10, true)
        }

        val btn_mas_10 = findViewById<Button>(R.id.btn_mas_10)
        btn_mas_10.setOnClickListener {
            progressBarHorizontal.setProgress(progressBarHorizontal.progress + 10, true)
        }

        val btn_esconder = findViewById<Button>(R.id.btn_enconderHorizontal)
        btn_esconder.setOnClickListener {
            progressBarHorizontal.visibility = View.INVISIBLE
        }

        val btn_mostrar = findViewById<Button>(R.id.btn_mostrarHorizontal)
        btn_mostrar.setOnClickListener {
            progressBarHorizontal.visibility = View.VISIBLE
        }

        val videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        videoView.start()

        val btn_pause = findViewById<Button>(R.id.btn_pauseVideo)
        btn_pause.setOnClickListener {
            stopPosition = videoView.currentPosition
            videoView.pause()
        }

        val btn_start = findViewById<Button>(R.id.btn_startVideo)
        btn_start.setOnClickListener {
            Toast.makeText(applicationContext, videoView.currentPosition.toString(), Toast.LENGTH_LONG).show()
            videoView.seekTo(videoView.currentPosition * 3)
            videoView.start()
        }




    }


}