package com.example.familywidgets

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

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

        val btn_setDate = findViewById<Button>(R.id.btn_setDate)
        btn_setDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.set(
                1951,

                2,

                31
            )
            calendarView.date = calendar.timeInMillis
        }

    }

}