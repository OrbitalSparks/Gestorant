package com.example.gestorant

class Direccion {
    var calle=""
    var numero=0

    constructor(calle: String, numero: Int) {
        this.calle = calle
        this.numero = numero
    }


    override fun toString(): String {
        return "Direccion: Calle: $calle, Numero :$numero"
    }


}