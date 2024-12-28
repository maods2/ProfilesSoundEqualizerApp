package com.example.profilessoundequalizerapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class Profile(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name: String, // Nome do perfil
    var bass: Float = 0.5f, // Valor de equalização do bass
    var mid: Float = 0.5f, // Valor de equalização do mid
    var high: Float = 0.5f, // Valor de equalização do high
    var volume: Float = 0.5f // Valor do volume
)

