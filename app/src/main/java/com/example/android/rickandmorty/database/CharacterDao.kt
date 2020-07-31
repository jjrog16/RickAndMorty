package com.example.android.rickandmorty.database

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao{
    @Query("SELECT * FROM DatabaseCharacter")
    fun getCharacters(): LiveData<List<DatabaseCharacter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg character: DatabaseCharacter)
}