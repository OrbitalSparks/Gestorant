package com.example.gestorant


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gestorant.Storage.Dataalmacen
import com.example.gestorant.Storage.Dataalmacen.Companion.dataproductos
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        var imagenD = findViewById<ImageView>(R.id.imagen2)

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





        fun go(){
            var retrofit= Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Apiservice::class.java)
            var retrodata=retrofit.getimagerandom()

            retrodata.enqueue(object : Callback<List<Drinks>> {
                override fun onResponse(call: Call<List<Drinks>>, response: Response<List<Drinks>>) {
                    var listadr= response.body()!!
                    var txt= StringBuilder()
                    var lists= arrayListOf<String>()
                    if (!response.isSuccessful){
                        Toast.makeText(this@MainActivity,response.code().toString(), Toast.LENGTH_SHORT).show()
                    }
                    if (listadr!=null){
                        for (cadalistadr in listadr){
                            txt.append(cadalistadr.image_url)
                            lists.add(cadalistadr.image_url).toString()
                            txt.append("\n")
                        }
                    }
                    var a=(0..24)
                    var random=a.random()
                    Picasso.get()
                        .load(lists[random])
                        .resize(130,540)
                        .into(imagenD)
                }

                override fun onFailure(call: Call<List<Drinks>>, t: Throwable) {
                    t.printStackTrace()
                }
            })}

        go()
    }
}