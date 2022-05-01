package com.example.familywidgets

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Activity_menu : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn_image_web = findViewById<Button>(R.id.btn_web_view_image_view)
        val btn_calendar_progress = findViewById<Button>(R.id.btn_calendar_progress)
        val btn_video_progress_horizontall = findViewById<Button>(R.id.btn_video_progress_horizontall)


        btn_image_web.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_calendar_progress.setOnClickListener {
            val intent = Intent(this, Activity_second::class.java)
            startActivity(intent)
        }

        btn_video_progress_horizontall.setOnClickListener {
            val intent = Intent(this, Activity_three::class.java)
            startActivity(intent)
        }
    }
}