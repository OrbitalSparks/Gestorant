package com.example.gestorant

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorant.Storage.Dataalmacen.Companion.dataproductos


class AgreProdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agre_prod)

        var valornombre= findViewById<EditText>(R.id.valornombre)
        var valorprecio= findViewById<EditText>(R.id.valorApellido)
        var valorcantidad= findViewById<EditText>(R.id.valorDni)
        var botonagre= findViewById<Button>(R.id.buttonAgregarPersona)
        var proveedor= findViewById<EditText>(R.id.valorProovedor)
        var spinnerlist= findViewById<Spinner>(R.id.spinnertipo)

        var myArray=arrayOf("Alimentos","Articulos de cocina")
        var spinnerlista= ArrayAdapter(this,android.R.layout.simple_spinner_item,myArray)
        spinnerlist.adapter=spinnerlista

        val produc = intent.getParcelableExtra<Producto>("prod")
        if (produc != null) {
            valornombre.setText(produc.NombreProducto)
            valorprecio.setText(produc.Precio.toString())
            valorcantidad.setText(produc.Cantidad.toString())
            proveedor.setText(produc.Proovedor)
        }

        botonagre.setOnClickListener{
            var productonew=Producto(valornombre.text.toString(),spinnerlist.selectedItem.toString(),valorprecio.text.toString().toDouble(),valorcantidad.text.toString().toInt(),proveedor.text.toString().trim())
            Toast.makeText(this,"Producto Agregado",Toast.LENGTH_SHORT).show()
            dataproductos.remove(produc)
            dataproductos.add(productonew)
            val miIntent = Intent(this,MainActivity::class.java)
            startActivity(miIntent)
        }
    }







}