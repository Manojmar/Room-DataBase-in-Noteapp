package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private lateinit var button: FloatingActionButton
    private lateinit var rec: RecyclerView
    private lateinit var myadapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Set Id*/
        button = findViewById(R.id.first_icon)
        rec = findViewById(R.id.Recycler)


        rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        /*Set Click Button*/
        button.setOnClickListener() {
            startActivity(Intent(this, add_item::class.java))
        }
         val data=MyData.getInput(applicationContext)!!.Notedata()

       CoroutineScope(Dispatchers.IO).launch {
           val list= data.getAllNotes()
           withContext(Dispatchers.Main){
               /*Set Adapter*/
               myadapter = Adapter(list)
               /*Set Recycler ViewAdapter */
               rec.adapter = myadapter

       }

       }

 

        }
    }









