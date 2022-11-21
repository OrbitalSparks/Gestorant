package com.example.gestorant.Storage

import com.example.gestorant.Direccion
import com.example.gestorant.Empleados
import com.example.gestorant.Producto

  class  Dataalmacen {

    companion object {
        var dataproductos: ArrayList<Producto> = arrayListOf<Producto>()

        var dataPersonas: ArrayList<Empleados> = arrayListOf<Empleados>()

    }

    fun  cargardatos() {
        dataproductos.add(Producto("Fideos","Alimentos",80.5,40,"Matarazo"))
        dataproductos.add(Producto("Harina","Alimentos",60.0,40,"Blanca flor"))
        dataproductos.add(Producto("Aceite","Alimentos",250.0,40,"Cocinero"))
        dataPersonas.add(Empleados("Sergio","Perez",45128642,44885566,80000.0 ,Direccion("Lima",500),"Cajero/a"))
        dataPersonas.add(Empleados("Ana","Diaz",50128582,46855566,1200000.0 ,Direccion("libertador",850),"Chef"))
        dataPersonas.add(Empleados("Lucas","Arias",34122699,48488511,100000.0 ,Direccion("Jujuy",895),"Personal de limpieza"))
    }

    fun  setalmacen(producto: Producto) {
         dataproductos.add(producto)
     }

}