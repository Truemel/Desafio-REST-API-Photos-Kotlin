package com.example.restapidesafiodos.modelo

import retrofit2.Call
import retrofit2.Callback

class RetrofitRequests {

    private var request:Api

    init {
        request = RetrofitClient.getRetro().create(Api::class.java)
    }

    fun requestPhotoList(callB:Callback<ArrayList<Photo>>){
        var call:Call<ArrayList<Photo>> = request.getUserPhotoList()
        call.enqueue(callB)
    }
}