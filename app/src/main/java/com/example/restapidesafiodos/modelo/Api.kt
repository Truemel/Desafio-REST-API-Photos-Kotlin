package com.example.restapidesafiodos.modelo

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("photos")
    fun getUserPhotoList():Call<ArrayList<Photo>>
}