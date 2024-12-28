package com.example.profilessoundequalizerapp

import android.app.Application
import androidx.room.Room
import com.example.profilessoundequalizerapp.model.dao.SoundEqualizerDB

class MainApplication: Application() {

    companion object {
        lateinit var soundProfilesDB: SoundEqualizerDB
    }

    override fun onCreate() {
        super.onCreate()
        var soundProfilesDB = Room.databaseBuilder(
            applicationContext,
            SoundEqualizerDB::class.java,
            SoundEqualizerDB.NAME
        ).build()
    }

}