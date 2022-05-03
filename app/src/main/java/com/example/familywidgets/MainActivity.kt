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

        val imageView = findViewById<ImageView>(R.id.imageView)

        val btn_increase_size = findViewById<Button>(R.id.btn_increase_size)
        btn_increase_size.setOnClickListener {
            Toast.makeText(applicationContext, imageView.height.toString() + " " + imageView.width.toString(), Toast.LENGTH_LONG).show()
            imageView.getLayoutParams().height =  215; //can change the size according to you requirements
            imageView.getLayoutParams().width = 215; //--
            imageView.requestLayout()
        }

        val btn_decrease_size = findViewById<Button>(R.id.btn_decrease_size)
        btn_decrease_size.setOnClickListener {
            Toast.makeText(applicationContext, imageView.height.toString() + " " + imageView.width.toString(), Toast.LENGTH_LONG).show()
            imageView.getLayoutParams().height =  100; //can change the size according to you requirements
            imageView.getLayoutParams().width = 100; //--
            imageView.requestLayout()
        }

        val btn_image_1 = findViewById<Button>(R.id.btn_image_1)
        btn_image_1.setOnClickListener {
            imageView.setBackgroundResource(R.drawable.ic_launcher_background)
        }

        val btn_image_2 = findViewById<Button>(R.id.btn_image_2)
        btn_image_2.setOnClickListener {
            imageView.setBackgroundResource(R.drawable.ic_launcher_foreground)
        }


        // ------------------INICIALIZACION DEL WEB VIEW
        val webView  = findViewById<WebView>(R.id.webView)
        webView.webChromeClient = object : WebChromeClient(){
        }
        webView.webViewClient = object : WebViewClient(){
        }
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.loadUrl(URL)

        val btn_pause = findViewById<Button>(R.id.btn_pause)
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
        //------------------INICIALIZACION VIDEO VIEW--------------


        //------------------INICIALIZACION BOTON-------------------

    }

    fun do_onclickImage(view: View) {
        Toast.makeText(applicationContext,"METHODO ON CLICK (IMAGE_VIEW)",Toast.LENGTH_SHORT).show()

    }


}