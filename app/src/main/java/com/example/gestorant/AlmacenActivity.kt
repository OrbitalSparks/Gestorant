package com.example.gestorant

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorant.Storage.Dataalmacen.Companion.dataproductos


class AlmacenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_almacen)

        var valornombre= findViewById<TextView>(R.id.datitos)
        var lvldatos =findViewById<ListView>(R.id.listviwreee)
        valornombre.text="Lista de Productos"
        var apadtarlista =ArrayAdapter<Producto>(this,android.R.layout.simple_list_item_1,
            dataproductos)
        lvldatos.adapter=apadtarlista

        lvldatos.setOnItemClickListener(){parent,view,position,id->

            var name = dataproductos[position]

            val miIntent = Intent(this, AgreProdActivity::class.java)
            miIntent.putExtra("prod",name)
            startActivity(miIntent)

        }

    }

}