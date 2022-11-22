package com.example.gestorant

class Usuarios() : Persona() {
    var nomBreuser : String = ""
    var contraseña : String = ""

   constructor(nomBreuser: String, contraseña: String,id: Int) : this() {
        this.id=id
        this.nomBreuser= nomBreuser
        this.contraseña= contraseña
   }

    constructor(nomBreuser: String, contraseña: String ): this() {
        this.nomBreuser= nomBreuser
        this.contraseña= contraseña
    }

}