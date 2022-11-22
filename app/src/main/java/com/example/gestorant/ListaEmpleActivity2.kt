package com.example.gestorant

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorant.Storage.Dataalmacen
import com.example.gestorant.Storage.Dataalmacen.Companion.dataPersonas

class ListaEmpleActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_emple2)


        var valornombre= findViewById<TextView>(R.id.textViewemple)
        var lvldat =findViewById<ListView>(R.id.listaemp)

        valornombre.text="Lista de Empleados"
        var apadtarlista = ArrayAdapter<Empleados>(this,android.R.layout.simple_list_item_1,
            dataPersonas
        )
        lvldat.adapter=apadtarlista


        lvldat.setOnItemClickListener(){parent,view,position,id->

            var name = dataPersonas[position]

          //  val miIntent = Intent(this, AgrepersActivity::class.java)
          // miIntent.putExtras("prod",name)
          //   startActivity(miIntent)




        }
    }


}




