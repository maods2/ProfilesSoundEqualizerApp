package com.example.profilessoundequalizerapp.model.dao

import android.provider.ContactsContract
import androidx.room.*
import androidx.room.Dao
import com.example.profilessoundequalizerapp.model.entity.Profile
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profiles")
    fun getAllProfiles(): Flow<List<ContactsContract.Profile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)
}