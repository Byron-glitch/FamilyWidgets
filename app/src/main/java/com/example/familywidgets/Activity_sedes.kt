package com.example.familywidgets

import android.content.res.AssetFileDescriptor
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.TextureView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Activity_sedes : AppCompatActivity(), TextureView.SurfaceTextureListener{

    val mediaPlayer = MediaPlayer()
    lateinit var fileDescriptor: AssetFileDescriptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sedes)

        val textureView = findViewById<TextureView>(R.id.textureView)
        textureView.surfaceTextureListener = this
        fileDescriptor = assets.openFd("Campus Universitarios UNA.mp4")

    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {
        val surface = Surface(surface)
        mediaPlayer.setDataSource(fileDescriptor)
        mediaPlayer.setSurface(surface)
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener { mediaPlayer -> mediaPlayer.start() }

    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {

    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        mediaPlayer.stop()
        mediaPlayer.release()
        return true
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {

    }

}