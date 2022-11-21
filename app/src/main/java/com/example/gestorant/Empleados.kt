package com.example.gestorant


 class Empleados(
    var nombre: String,
    var apellido: String,
    var dni: Int,
    var telefono: Int,
    var salario: Double,
    var direccion: Direccion,
    var carrgo: String,
    ):Persona() {


    override fun toString(): String {
       return "Nombre: $nombre, Apellido: $apellido, DNI: $dni\nTelefono: $telefono, Salario: $salario\nDireccion: $direccion, Cargo: $carrgo"
    }
 }