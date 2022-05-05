package com.example.familywidgets

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import androidx.annotation.RequiresApi
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val URL = "https://www.una.ac.cr/"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val progress_bar  = findViewById<ProgressBar>(R.id.progressBar)
        progress_bar.visibility = View.VISIBLE


        // ------------------INICIALIZACION DEL WEB VIEW
        val webView  = findViewById<WebView>(R.id.webView)
        webView.webChromeClient = object : WebChromeClient(){
        }
        webView.webViewClient = object : WebViewClient(){
        }
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.loadUrl(URL)
        progress_bar.visibility = View.INVISIBLE


        val btn_pause = findViewById<Button>(R.id.btn_pauseWeb)
        btn_pause.setOnClickListener {
            webView.onPause()
        }
        val btn_resume = findViewById<Button>(R.id.btn_resume)
        btn_resume.setOnClickListener {
            webView.onResume()
        }

        val btn_back = findViewById<Button>(R.id.btn_goback)
        btn_back.setOnClickListener {
            if(webView.canGoBack()) webView.goBack()
        }

        val btn_forward = findViewById<Button>(R.id.btn_goforward)
        btn_forward.setOnClickListener {
            if(webView.canGoForward()) webView.goForward()

        }

        var txt_url = findViewById<EditText>(R.id.txt_url)
        txt_url.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                // if the event is a key down event on the enter button
                if (event.action == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                    webView.loadUrl(txt_url.text.toString())
                    return true
                }
                return false
            }
        })



    }



}