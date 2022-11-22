package com.example.gestorant

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.net.URL

class LoginUI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ui)
//definir variables para las entradas y botones
        val txtusuario = findViewById<EditText>(R.id.textInputIDUsuario)
        val txtpasword = findViewById<EditText>(R.id.txIDPassword)
        val btnPresioname = findViewById<Button>(R.id.Backbutton)
        val imagen = findViewById<ImageView>(R.id.imageView222)
        //api picasso
        Picasso.get()
            .load(Randomimage())
            .resize(750, 400)
            .centerCrop()
            .into(imagen)

        //acciones del boton de ingreso
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

    //crecion del usuario a entrar
    var usernames = Usuarios("admin","12345",1)

    //validar user
    private fun ingresar(txtusuariostring: String, txtpasswordstring: String) {

        var user = Usuarios(txtusuariostring,txtpasswordstring)

        if (user.nomBreuser == usernames.nomBreuser){
            if (user.contraseña == usernames.contraseña){
                //ingreso exitoso
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
            1 -> return ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6OaXEWDq0MX8kJxp9C4l1gXqnG8OQzorMww&usqp=CAU")
            2 -> return ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWc3ERFJV96AiLcDSS0R6r_Dj33xlX6kuDw7S4tMd8D8vrhivMqfhuEb4kUB4tl_eqR14&usqp=CAU")
            3 -> return ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHWhQJfMDTDSyMzWk2dj1r0srSiObZuiiPpQ&usqp=CAU")
            4 -> return ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY-0NH9kk7svIgbT6_AeAA5PSGUw79-kn0XQ&usqp=CAU")
            5 -> return ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaFTWMso-ML0ftoEQyFE-t9kCFVAfcIWUdoA&usqp=CAU")

        }
        return ""


    }
}