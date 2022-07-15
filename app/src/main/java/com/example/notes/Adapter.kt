package com.example.notes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Adapter(var list: List<Model>) :RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
           var baru=view.findViewById<TextView>(R.id.title)
           var mano=view.findViewById<TextView>(R.id.para)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val out=list[position]
        holder.baru.text=out.name
        holder.mano.text=out.description

//        holder.itemView.setOnClickListener(){
//            val intent= Intent(this,edit::class.java)
//            startActivity(intent)
//        }



    } override fun getItemCount(): Int {
        return list.size

    }
}