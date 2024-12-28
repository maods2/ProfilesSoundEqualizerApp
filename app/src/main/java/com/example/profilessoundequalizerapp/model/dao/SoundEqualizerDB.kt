package com.example.profilessoundequalizerapp.model.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.profilessoundequalizerapp.model.entity.Profile


@Database(entities = [Profile::class], version = 1)
@TypeConverters(Converters::class)
abstract class SoundEqualizerDB : RoomDatabase(){

    companion object {
        const val NAME = "sound_profiles_db"
    }

    abstract fun getProfileDao() : ProfileDao

}