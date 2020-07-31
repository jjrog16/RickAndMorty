package com.example.android.rickandmorty.network

import com.example.android.rickandmorty.database.DatabaseCharacter
import com.squareup.moshi.JsonClass

/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 */

@JsonClass(generateAdapter = true)
data class NetworkCharacterContainer(val characters: List<NetworkCharacter>)

@JsonClass(generateAdapter = true)
data class NetworkCharacter(
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

/**
 * Convert Network results to database objects
 */
fun NetworkCharacterContainer.asDatabaseModel(): Array<DatabaseCharacter>{
    return characters.map {
        DatabaseCharacter(
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
    }.toTypedArray()
}