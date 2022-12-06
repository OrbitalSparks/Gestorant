package com.example.gestorant

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.URL

class LoginUI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pica:Picasso
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ui)
        val txtusuario = findViewById<EditText>(R.id.textInputIDUsuario)
        val txtpasword = findViewById<EditText>(R.id.txIDPassword)
        val btnPresioname = findViewById<Button>(R.id.Backbutton)
        val imagen = findViewById<ImageView>(R.id.imageView222)

        Picasso.get()
            .load(Randomimage())
            .resize(750, 400)
            .centerCrop()
            .into(imagen)



        btnPresioname.setOnClickListener {
            val txtusuariostring = txtusuario.text.toString().trim()
            val txtpasswordstring = txtpasword.text.toString().trim()

            if (txtusuariostring.isEmpty()){
                Toast.makeText(this,"Usuario vacio", Toast.LENGTH_SHORT).show()
            }
            if (txtpasswordstring.isEmpty()){
                Toast.makeText(this,"Contraseña vacio", Toast.LENGTH_SHORT).show()
            }else{
                ingresar(txtusuariostring, txtpasswordstring)
            }


        }

    }
    var usernames = Usuarios("admin","12345",1)

    private fun ingresar(txtusuariostring: String, txtpasswordstring: String) {

        var user = Usuarios(txtusuariostring,txtpasswordstring)

        if (user.nomBreuser == usernames.nomBreuser){
            if (user.contraseña == usernames.contraseña){
                Toast.makeText(this,"Ingresando", Toast.LENGTH_SHORT).show()
                val miIntent = Intent(this,MainActivity::class.java)
                startActivity(miIntent)

            }else{
                Toast.makeText(this,"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()}
        }else
        {
            Toast.makeText(this,"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
        }

    }


 fun Randomimage():String {
       var a = (1..5)
       when (a.random()) {
         1 -> return ("https://www.thecocktaildb.com/images/media/drink/yqvvqs1475667388.jpg")
         2 -> return ("https://www.thecocktaildb.com/images/media/drink/qyyvtu1468878544.jpg")
         3 -> return ("https://www.thecocktaildb.com/images/media/drink/i9suxb1582474926.jpg")
         4 -> return ("https://www.thecocktaildb.com/images/media/drink/xvwusr1472669302.jpg")
         5 -> return ("https://www.thecocktaildb.com/images/media/drink/wysqut1461867176.jpg")
      }
    return ""

    }
}