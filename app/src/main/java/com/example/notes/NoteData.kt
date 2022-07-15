package com.example.notes



import androidx.room.*


@Dao
interface NoteData {



  @Insert
  fun insert(m:Model)

  @Update
  fun update(m:Model)

  @Delete
  fun delete(m:Model)

  @Query("select * from Data")
  fun getAllNotes():List<Model>
}