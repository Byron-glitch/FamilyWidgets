package com.example.familywidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.widget.SearchView

class Activity_questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val searchView = findViewById<SearchView>(R.id.searchView)
        val listView = findViewById<ListView>(R.id.listView)

        val list = ArrayList<String>()
        list.add("¿Cómo me inscribo al proceso de admisión 2022-2023?")
        list.add("¿Cuáles carreras ofrece la UNA?")
        list.add("¿Cómo puedo cambiarme de carrera o cursar una segunda carrera?")
        list.add("¿Cuánto cuestan las carreras en la UNA?")
        list.add("¿Cuáles son los requisitos para empadronarme?")
        list.add("¿Cuándo puedo entregar los documentos para empadronarme?")
        list.add("¿Cómo puedo retirar la certificación?")
        list.add("¿Cuánto tiempo tardan en confeccionar mi certificación?")
        list.add("¿En dónde puedo consultar los cortes de carrera?")
        list.add("¿Qué es el promedio de Admisión?")
        list.add("¿Qué hacer para mantener vigente (congelar) el resultado de la Prueba de Aptitud Académica (Examen de Admisión) 2022, para ingresar en el 2023?")
        list.add("¿Cuándo me doy cuenta si quedé admitido en una carrera?")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        searchView?.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                Toast.makeText(applicationContext, "Buscando...", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        searchView?.setOnCloseListener {
            Toast.makeText(applicationContext, "Cerrando búsqueda", Toast.LENGTH_SHORT).show()
            false
        }

        val ratingBarOpinion = findViewById<RatingBar>(R.id.ratingBarOpinion)

        ratingBarOpinion?.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                when (rating.toInt()) {
                    1 -> Toast.makeText(applicationContext, "Muy mala", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext, "Mala", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext, "Regular", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(applicationContext, "Buena", Toast.LENGTH_SHORT).show()
                    5 -> Toast.makeText(applicationContext, "Excelente", Toast.LENGTH_SHORT).show()
                    else -> {
                        Toast.makeText(applicationContext, "Error al obtener valoración", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }
}