package com.example.notes


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Model::class],version = 1,exportSchema = false)
abstract class MyData: RoomDatabase() {

    companion object {
        private  var Input: MyData?=null

        fun getInput(context: Context):MyData? {

            if (Input == null) {

                synchronized(MyData::class.java) {
                    Input= Room.databaseBuilder(
                    context.applicationContext,
                    MyData::class.java,
                    "MyData"
                    ).build()
                  return Input

                }
            }
              return Input
        }


    }
    abstract fun Notedata():NoteData

}