package com.example.profilessoundequalizerapp.model.dao


import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.profilessoundequalizerapp.model.entity.Profile


@Dao
interface ProfileDao {
    @Insert
    suspend fun addProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)

    @Query("SELECT * FROM Profile")
    fun getAllProfiles(): LiveData<List<Profile>>

}