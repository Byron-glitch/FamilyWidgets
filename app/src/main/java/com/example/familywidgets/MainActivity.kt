package com.example.familywidgets

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import androidx.annotation.RequiresApi
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.VideoView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val URL = "https://www.una.ac.cr/"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // ------------------INICIALIZACION DEL WEB VIEW
        val webView  = findViewById<WebView>(R.id.webView)
        webView.webChromeClient = object : WebChromeClient(){
        }
        webView.webViewClient = object : WebViewClient(){
        }
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.loadUrl(URL)

        webView.onPause()
        //------------------INICIALIZACION VIDEO VIEW--------------
        var videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setOnClickListener {
            videoView.start()
        }

        //------------------INICIALIZACION BOTON-------------------
        var btn_next = findViewById<Button>(R.id.btn_next)

        btn_next.setOnClickListener {
            val intent = Intent(this, Activity_second::class.java)
            startActivity(intent)
        }

    }

    fun do_onclickImage(view: View) {
        Toast.makeText(applicationContext,"METHODO ON CLICK (IMAGE_VIEW)",Toast.LENGTH_SHORT).show()

    }


}