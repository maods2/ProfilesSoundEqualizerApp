package com.example.profilessoundequalizerapp.model.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.profilessoundequalizerapp.model.entity.Profile


@Database(entities = [Profile::class], version = 1)
@TypeConverters(Converters::class)
abstract class SoundProfileDatabase : RoomDatabase(){

    companion object {
        const val NAME = "sound_profiles.db"
    }

    abstract val dao: ProfileDao


}