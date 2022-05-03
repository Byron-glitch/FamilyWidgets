package com.example.familywidgets

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class Activity_eight : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight)

        val seekBarNormal= findViewById<SeekBar>(R.id.seekbar_Normal)
        val seekBarDiscrete = findViewById<SeekBar>(R.id.seekbar_Discrete)
        val txtViewSeekBarNormal = findViewById<TextView>(R.id.textViewSeekBar)
        val txtViewSeekBarDiscrete = findViewById<TextView>(R.id.textViewSeekBarDiscrete)

        seekBarNormal?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                txtViewSeekBarNormal.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "Iniciando SeekBar Normal", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Toast.makeText(applicationContext, "Parando SeekBar Normal", Toast.LENGTH_SHORT).show()
            }
        })

        var min = seekBarNormal.min
        var max = seekBarNormal.max

        val btnMinAumentar = findViewById<Button>(R.id.btnMinAumentar)
        btnMinAumentar.setOnClickListener {
            if (min < max - 1) {
                min += 1
                seekBarNormal?.min = min
            } else {
                Toast.makeText(applicationContext, "Ya No Se Puede Aumentar el Valor Minimo", Toast.LENGTH_SHORT).show()
            }
        }

        val btnMinDisminuir = findViewById<Button>(R.id.btnMinDisminuir)
        btnMinDisminuir.setOnClickListener {
            min -= 1
            seekBarNormal?.min = min
        }

        val btnMaxAumentar = findViewById<Button>(R.id.btnMaxAumentar)
        btnMaxAumentar.setOnClickListener {
            max += 1
            seekBarNormal?.max = max
        }

        val btnMaxDisminuir = findViewById<Button>(R.id.btnMaxDisminuir)
        btnMaxDisminuir.setOnClickListener {
            if (max > min + 1) {
                max -= 1
                seekBarNormal?.max = max
            } else {
                Toast.makeText(applicationContext, "Ya No Se Puede Disminuir el Valor Maximo", Toast.LENGTH_SHORT).show()
            }
        }

        seekBarDiscrete?.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtViewSeekBarDiscrete.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "Iniciando SeekBar Discrete", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "Parando SeekBar Discrete", Toast.LENGTH_SHORT).show()
            }
        })

        var min2 = seekBarDiscrete.min
        var max2 = seekBarDiscrete.max

        val btnMinAumentar2 = findViewById<Button>(R.id.btnMinAumentar2)
        btnMinAumentar2.setOnClickListener {
            if (min2 < max2 - 1) {
                min2 += 1
                seekBarDiscrete?.min = min2
            } else {
                Toast.makeText(applicationContext, "Ya No Se Puede Aumentar el Valor Minimo", Toast.LENGTH_SHORT).show()
            }
        }

        val btnMinDisminuir2 = findViewById<Button>(R.id.btnMinDisminuir2)
        btnMinDisminuir2.setOnClickListener {
            min2 -= 1
            seekBarDiscrete?.min = min2
        }

        val btnMaxAumentar2 = findViewById<Button>(R.id.btnMaxAumentar2)
        btnMaxAumentar2.setOnClickListener {
            max2 += 1
            seekBarDiscrete?.max = max2
        }

        val btnMaxDisminuir2 = findViewById<Button>(R.id.btnMaxDisminuir2)
        btnMaxDisminuir2.setOnClickListener {
            if (max2 > min2 + 1) {
                max2 -= 1
                seekBarDiscrete?.max = max2
            } else {
                Toast.makeText(applicationContext, "Ya No Se Puede Disminuir el Valor Maximo", Toast.LENGTH_SHORT).show()
            }
        }

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        ratingBar?.setOnRatingBarChangeListener(object :RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                Toast.makeText(applicationContext, "Rating cambiado", Toast.LENGTH_SHORT).show()
            }
        })

        var numStars = ratingBar.numStars

        val btnAumentar = findViewById<Button>(R.id.btnAumentarEstrellas)
        btnAumentar.setOnClickListener {
            if (numStars < 8) {
                numStars += 1
                ratingBar?.numStars = numStars
            } else {
                Toast.makeText(applicationContext, "Maximo de Estrellas Alcanzado", Toast.LENGTH_SHORT).show()
            }
        }

        val btnDisminuir = findViewById<Button>(R.id.btnDisminuirEstrellas)
        btnDisminuir.setOnClickListener {
            if (numStars > 1) {
                numStars -= 1
                ratingBar?.numStars = numStars
            } else {
                Toast.makeText(applicationContext, "Minimo de Estrellas Alcanzado", Toast.LENGTH_SHORT).show()
            }
        }

        val btnEstado = findViewById<Button>(R.id.btnEstado)
        btnEstado.setOnClickListener {
            val estado = ratingBar.isIndicator

            if (estado) {
                ratingBar?.setIsIndicator(false)
                Toast.makeText(applicationContext, "RatingBar Habilitado", Toast.LENGTH_SHORT).show()
            }  else {
                ratingBar?.setIsIndicator(true)
                Toast.makeText(applicationContext, "RatingBar Inhabilitado", Toast.LENGTH_SHORT).show()
            }
        }

        val btnNext = findViewById<Button>(R.id.btnThirdNext)
        btnNext.setOnClickListener {
            val intent = Intent(this, Activity_nine::class.java)
            startActivity(intent)
        }

    }

}