package com.example.profilessoundequalizerapp.data.dao

import android.provider.ContactsContract
import androidx.room.*
import androidx.room.Dao
import com.example.profilessoundequalizerapp.data.model.Profile
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