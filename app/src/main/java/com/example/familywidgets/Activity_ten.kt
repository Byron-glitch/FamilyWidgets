package com.example.familywidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView

class Activity_ten : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ten)

        val searchView = findViewById<SearchView>(R.id.searchView)
        val listView = findViewById<ListView>(R.id.listView)

        val list = ArrayList<String>()
        list.add("Real Madrid")
        list.add("Fc Barcelona")
        list.add("Manchester United")
        list.add("Chelsea")
        list.add("Paris Saint Germain")
        list.add("Manchester City")
        list.add("Liverpool")
        list.add("Atletico de Madrid")
        list.add("Arsenal")
        list.add("Juventus")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter

        searchView?.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                Toast.makeText(applicationContext, "Usando onQueryTextSubmit", Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        searchView?.setOnCloseListener {
            Toast.makeText(applicationContext, "Cerrando searchView", Toast.LENGTH_SHORT).show()
            false
        }

    }
}