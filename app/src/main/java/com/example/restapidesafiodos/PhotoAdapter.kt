package com.example.restapidesafiodos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapidesafiodos.modelo.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(var list:ArrayList<Photo>, var context: Context):RecyclerView.Adapter<PhotoAdapter.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view){
        lateinit var image:ImageView
        lateinit var title:TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.photos_list_item, parent, false)
        var holder:Holder = Holder(view)
        holder.image = view.findViewById(R.id.image)
        holder.title = view.findViewById(R.id.title)

        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = list.get(position).title
        //Glide.with(context).load(list.get(position).url).into(holder.image)
        Picasso.get().load(list.get(position).url).into(holder.image);
    }

    override fun getItemCount(): Int {
        return list.size
    }
}