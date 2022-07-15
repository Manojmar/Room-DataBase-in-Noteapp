package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Data")
data class Model (
    @ColumnInfo(name="id")
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name="Title")
    var name:String,
    @ColumnInfo (name="Description")
    var description:String
    )
