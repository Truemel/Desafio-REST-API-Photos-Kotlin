package com.example.restapidesafiodos.modelo

import com.google.gson.annotations.SerializedName

data class Photo(val id:Short, val title:String, val url:String, @SerializedName("thumbnailUrl") val thumbnail:String)