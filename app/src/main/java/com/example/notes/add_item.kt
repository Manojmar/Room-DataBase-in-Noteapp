package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import java.util.Collections.addAll

class add_item : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var  edit1:EditText
    private lateinit var edit2:EditText
    private lateinit var myadapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        button1 = findViewById(R.id.button2)
         edit1 = findViewById(R.id.edit1)
         edit2 = findViewById(R.id.edit2)

        button1.setOnClickListener {

            val title = edit1.text.toString().trim()
            val para = edit2.text.toString().trim()

            if (title.trim().isBlank() or para.trim().isBlank()) {
                Toast.makeText(this, "Required Field is empty", Toast.LENGTH_SHORT).show()
            }else{
                val db =MyData.getInput(this)?.Notedata()
                val mo=Model(0,"Title:$title","Para:$para")
                myadapter.notifyDataSetChanged()
                GlobalScope.launch {
                    db?.insert(mo)
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@add_item,"NoteSaved",Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }

            }


        }
    }
}