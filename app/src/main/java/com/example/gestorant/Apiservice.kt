package com.example.gestorant

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.http.GET
interface Apiservice {
    @GET("beers")
    fun getimagerandom(): Call<List<Drinks>>
}