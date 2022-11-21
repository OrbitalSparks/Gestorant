package com.example.gestorant

import android.os.Parcel
import android.os.Parcelable


data class Producto(var NombreProducto:String,
                    var Tipo:String,
                    var Precio:Double,
                    var Cantidad:Int,
                    var Proovedor:String,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(NombreProducto)
        parcel.writeString(Tipo)
        parcel.writeDouble(Precio)
        parcel.writeInt(Cantidad)
        parcel.writeString(Proovedor)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Producto: $NombreProducto Tipo:$Tipo\nPrecio: $Precio $ Cantidad :$Cantidad\nProovedor :$Proovedor"
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }



}