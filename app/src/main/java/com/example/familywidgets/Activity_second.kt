package com.example.familywidgets

import android.os.Build
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Activity_second: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //------------------------INICIALIZACION CALENDAR VIEW

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            Toast.makeText(applicationContext, "$dayOfMonth/$month/$year", Toast.LENGTH_LONG).show()
        }

    }

}