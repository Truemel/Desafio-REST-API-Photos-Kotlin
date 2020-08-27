package com.example.restapidesafiodos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapidesafiodos.modelo.Photo
import com.example.restapidesafiodos.modelo.RetrofitRequests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<ArrayList<Photo>> {

    lateinit var listView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.recyclerV)
        listView.layoutManager = LinearLayoutManager(this)

        loadApiData()
    }

    fun loadApiData(){
        RetrofitRequests().requestPhotoList(this)
    }

    override fun onResponse(call: Call<ArrayList<Photo>>, response: Response<ArrayList<Photo>>) {
        if(response.isSuccessful && response.body() != null && response.body()!!.size > 0){
            listView.adapter =  PhotoAdapter(response.body()!!, this)
        }
    }

    override fun onFailure(call: Call<ArrayList<Photo>>, t: Throwable) {
        Toast.makeText(this, "Connection Failure", Toast.LENGTH_LONG).show()
    }
}