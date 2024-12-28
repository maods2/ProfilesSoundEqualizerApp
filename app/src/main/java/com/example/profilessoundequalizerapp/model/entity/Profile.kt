package com.example.profilessoundequalizerapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var bass: Float = 0.5f,
    var mid: Float = 0.5f,
    var high: Float = 0.5f,
    var volume: Float = 0.5f
)

