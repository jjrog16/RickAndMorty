package com.example.android.rickandmorty.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseCharacter::class], version = 1)
abstract class CharacterRoomDatabase : RoomDatabase(){
    abstract val characterDao: CharacterDao
}

private lateinit var INSTANCE: CharacterRoomDatabase

fun getDatabase(context: Context): CharacterRoomDatabase{
    synchronized(CharacterRoomDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                CharacterRoomDatabase::class.java,
                "character_database").build()
        }
    }
    return INSTANCE
}