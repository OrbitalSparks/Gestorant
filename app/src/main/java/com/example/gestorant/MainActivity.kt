package com.example.gestorant


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorant.Storage.Dataalmacen
import com.example.gestorant.Storage.Dataalmacen.Companion.dataproductos

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var datos=Dataalmacen();
        if (dataproductos.isEmpty()){
            datos.cargardatos()
        }
        val btnPresioname = findViewById<Button>(R.id.buttonAgregarProducto)
        val btnlistaprod = findViewById<Button>(R.id.buttonverProducto2)
        val btnlistaemp = findViewById<Button>(R.id.buttonListaempleados)
        val btnemp = findViewById<Button>(R.id.buttonAgregarEmpleado)

        btnPresioname.setOnClickListener {

            val miIntent = Intent(this, AgreProdActivity::class.java)
            startActivity(miIntent)

        }
        btnlistaprod.setOnClickListener {

            val miIntent = Intent(this, AlmacenActivity::class.java)
            startActivity(miIntent)

        }
        btnlistaemp.setOnClickListener {

            val miIntent = Intent(this, ListaEmpleActivity2::class.java)
            startActivity(miIntent)

        }
        btnemp.setOnClickListener {

            val miIntent = Intent(this, AgrepersActivity::class.java)
            startActivity(miIntent)

        }
    }
}