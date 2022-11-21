package com.example.gestorant

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorant.Storage.Dataalmacen

class AgrepersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agrepers)


        var spinnercargo= findViewById<Spinner>(R.id.spinnercargo)
        var valornombre= findViewById<EditText>(R.id.valornombre)
        var valorapellido= findViewById<EditText>(R.id.valorApellido)
        var valorDnI= findViewById<EditText>(R.id.valorDni)
        var valortelefono= findViewById<EditText>(R.id.editTextTelefono)
        var valorcalle= findViewById<EditText>(R.id.valorcalle)
        var valorcallenumero= findViewById<EditText>(R.id.editTexCallenumero)
        var valorsalario= findViewById<EditText>(R.id.editTextSalario)
        var botonagregarpersona= findViewById<Button>(R.id.buttonAgregarPersona)

        var myArray=arrayOf("Chef","Cajero/a","Personal de limpieza","Mozo/a")
        var spinnerlista= ArrayAdapter(this,android.R.layout.simple_spinner_item,myArray)
        spinnercargo.adapter=spinnerlista
        botonagregarpersona.setOnClickListener {
            var personanew=Empleados(valornombre.text.toString(),valorapellido.text.toString(),valorDnI.text.toString().toInt(),valortelefono.text.toString().toInt(),valorsalario.text.toString().toDouble(),Direccion(valorcalle.text.toString(),valorcallenumero.text.toString().toInt())
            ,spinnercargo.selectedItem.toString())

         //   Dataalmacen.dataPersonas.remove(produc)
            Dataalmacen.dataPersonas.add(personanew)
            Toast.makeText(this,"Persona Agregada", Toast.LENGTH_SHORT).show()
            val miIntent = Intent(this,MainActivity::class.java)
            startActivity(miIntent)
        }


      //  lvldatos.setOnItemClickListener(){parent,view,position,id->

            // Toast.makeText(this, parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()

         //   var name = Dataalmacen.dataproductos[position]
            //Toast.makeText(this, name.toString(),Toast.LENGTH_SHORT).show()

            //  var name =Producto()
            //  val miIntent = Intent(this, AgreProdActivity::class.java)
            //   startActivity(miIntent)
            //  miIntent.putExtra("product",product)


     //   }


    }
}