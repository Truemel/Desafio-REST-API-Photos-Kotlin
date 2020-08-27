package com.example.restapidesafiodos.modelo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private const val PATH:String = "https://jsonplaceholder.typicode.com/"
        private var retro:Retrofit? = null

        fun getRetro():Retrofit{
            if(retro == null)
                synchronized(this){
                    retro = Retrofit.Builder().baseUrl(PATH).addConverterFactory(GsonConverterFactory.create()).build()
                }
            return retro!!
        }
    }
}