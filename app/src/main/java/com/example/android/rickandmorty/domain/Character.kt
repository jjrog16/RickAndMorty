package com.example.android.rickandmorty.domain

import com.example.android.rickandmorty.database.LocationObject

/**
 * Domain objects are plain Kotlin data classes that represent the things in our app. These are the
 * objects that should be displayed on screen, or manipulated by the app.
 *
 * @see database for objects that are mapped to the database
 * @see network for objects that parse or prepare network calls
 */

/**
 * Character represents data regarding a character in Rick and Morty
 */
data class Character(
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