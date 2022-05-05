package com.example.familywidgets

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class Activity_second: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //-------------------------------CALENDAR VIEW----------------------------------------

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            when ("$dayOfMonth/$month/$year") {
                "16/4/2022" ->  Toast.makeText(applicationContext, "Ingreso a clases", Toast.LENGTH_LONG).show()
                "20/4/2022" -> Toast.makeText(applicationContext, "Día final de pago de matrícula", Toast.LENGTH_LONG).show()
                else -> { // Note the block
                    Toast.makeText(applicationContext, "No hay nada programado para esa fecha", Toast.LENGTH_LONG).show()
                }
            }
        }

        val btn_setDate = findViewById<Button>(R.id.btn_setDate)
        btn_setDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val myLdt = LocalDateTime.now()

            calendar.set(
                myLdt.year,

                myLdt.monthValue - 1,

                myLdt.dayOfMonth
            )
            calendarView.date = calendar.timeInMillis
        }

        //------------------------------------PROGRESS BAR HORIZONTAL------------------------------------
        val progressBarHorizontal = findViewById<ProgressBar>(R.id.progressBarHorizontalMatricula)
        progressBarHorizontal.setProgress(0, true)
        progressBarHorizontal.max = 180000

        val txt_monto = findViewById<EditText>(R.id.txt_monto)
        txt_monto.doAfterTextChanged {
            if(!txt_monto.text.toString().equals(""))
                if(txt_monto.text.toString().toInt() <= 180000)
                    progressBarHorizontal.setProgress(txt_monto.text.toString().toInt())
                else Toast.makeText(applicationContext, "Monto a pagar excedido", Toast.LENGTH_LONG).show()
        }


    }

}