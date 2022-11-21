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
      //  valornombre.text=dataproductos.toString()
        lvldatos.setOnItemClickListener(){parent,view,position,id->

           // Toast.makeText(this, parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()

            var name = dataproductos[position]
            //Toast.makeText(this, name.toString(),Toast.LENGTH_SHORT).show()


            val miIntent = Intent(this, AgreProdActivity::class.java)
            miIntent.putExtra("prod",name)
            startActivity(miIntent)








         //  var name =Producto()
          //  val miIntent = Intent(this, AgreProdActivity::class.java)
         //   startActivity(miIntent)
          //  miIntent.putExtra("product",product)


        }





    }

}