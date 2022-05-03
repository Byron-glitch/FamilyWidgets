package com.example.familywidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Activity_nine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine)

        val btnNext = findViewById<Button>(R.id.btnNextFourth)
        btnNext.setOnClickListener {
            val intent = Intent(this, Activity_ten::class.java)
            startActivity(intent)
        }

    }


}