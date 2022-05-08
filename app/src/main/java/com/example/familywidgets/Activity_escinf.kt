package com.example.familywidgets

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.annotation.RequiresApi

class Activity_escinf : AppCompatActivity(), SurfaceHolder.Callback2  {

    val mediaPlayer2 = MediaPlayer()
    lateinit var surfaceHolder: SurfaceHolder
    lateinit var fileDescriptor2: AssetFileDescriptor

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escinf)

        val surfaceView = findViewById<SurfaceView>(R.id.surfaceView)
        surfaceHolder = surfaceView.holder
        surfaceHolder.addCallback(this)
        fileDescriptor2 = assets.openFd("Escuela de Informática UNA.mp4")

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun surfaceCreated(holder: SurfaceHolder) {
        mediaPlayer2.setDisplay(holder)
        mediaPlayer2.setDataSource(fileDescriptor2)
        mediaPlayer2.prepareAsync()
        mediaPlayer2.setOnPreparedListener { mediaPlayer2 -> mediaPlayer2.start() }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        mediaPlayer2.stop()
        mediaPlayer2.release()
    }

    override fun surfaceRedrawNeeded(holder: SurfaceHolder) {

    }

}