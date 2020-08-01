package com.example.android.rickandmorty.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.rickandmorty.database.CharacterRoomDatabase
import com.example.android.rickandmorty.database.asDomainModel
import com.example.android.rickandmorty.domain.Character
import com.example.android.rickandmorty.network.Api
import com.example.android.rickandmorty.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersRepository(private val database: CharacterRoomDatabase){
    /**
     * A list of characters that can be shown on screen
     */
    val people: LiveData<List<Character>> = Transformations.map(database.characterDao.getCharacters()){
        it.asDomainModel()
    }

    /**
     * Refresh the characters stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     * To actually load the people for use, observe [people]
     */
    suspend fun refreshCharacters(){
        withContext(Dispatchers.IO){
            val items = Api.retrofitService.getCharactersAsync().await()
            // Take in vararg of recipes
            database.characterDao.insertAll(*items.asDatabaseModel())
        }
    }
}