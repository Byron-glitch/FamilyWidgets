package com.example.familywidgets

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class Activity_gallery : AppCompatActivity() {

    var currentImg : Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val btn_img_back = findViewById<ImageView>(R.id.img_back_btn)
        val btn_img_next = findViewById<ImageView>(R.id.img_next_btn)
        val seekbarDiscrete = findViewById<SeekBar>(R.id.seekBarDiscrete)

        var gallery = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3);
        currentImg = 0

        seekbarDiscrete.min = 0
        seekbarDiscrete.max = gallery.size - 1

        val img_photo = findViewById<ImageView>(R.id.img_photo)
        img_photo.setBackgroundResource(gallery[currentImg])

        btn_img_back.setOnClickListener {
            if(currentImg - 1 < 0)
                currentImg = gallery.size - 1
            else currentImg--
            seekbarDiscrete.progress = currentImg
            img_photo.setBackgroundResource(gallery[currentImg])
        }

        btn_img_next.setOnClickListener {
            if(currentImg + 1 >= gallery.size)
                currentImg = 0
            else currentImg++
            seekbarDiscrete.progress = currentImg
            img_photo.setBackgroundResource(gallery[currentImg])
        }

        val btn_img_masTamano = findViewById<ImageView>(R.id.btn_image_masTamano)
        val btn_img_menosTamano = findViewById<ImageView>(R.id.btn_image_menosTamano)
        Toast.makeText(this, img_photo.layoutParams.width.toString() + " " + img_photo.layoutParams.height, Toast.LENGTH_LONG).show()

        btn_img_masTamano.setOnClickListener {
            val params = img_photo.layoutParams
            params.height = 1141
            params.width = 943
            img_photo.layoutParams = params
        }

        btn_img_menosTamano.setOnClickListener {
            val params = img_photo.layoutParams
            params.height = 941
            params.width = 743
            img_photo.layoutParams = params

        }

        seekbarDiscrete?.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                currentImg = progress
                img_photo.setBackgroundResource(gallery[progress])
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }

}