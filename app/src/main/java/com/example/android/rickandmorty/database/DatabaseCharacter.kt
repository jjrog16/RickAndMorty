package com.example.android.rickandmorty.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.rickandmorty.domain.Character

@Entity
data class DatabaseCharacter(
    @PrimaryKey
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var image: String,
    var url: String,
    var created: String
)

// Take what is in the database and make that the Character
fun List<DatabaseCharacter>.asDomainModel(): List<Character>{
    return map{
        Character(
            id = it.id,
            name = it.name,
            status = it.status,
            species = it.species,
            type = it.type,
            gender = it.gender,
            image = it.image,
            url = it.url,
            created = it.created
        )
    }
}