package com.example.android.rickandmorty.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseCharacter(
    @PrimaryKey
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: LocationObject,
    var location: LocationObject,
    var image: String,
    var url: String,
    var created: String

)