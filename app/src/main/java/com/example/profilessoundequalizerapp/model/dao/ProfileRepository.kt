package com.example.profilessoundequalizerapp.model.dao

import com.example.profilessoundequalizerapp.model.entity.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileRepository {
    private val _profiles = MutableStateFlow<List<Profile>>(emptyList())
    val profiles: StateFlow<List<Profile>> = _profiles

    suspend fun addProfile(profile: Profile) {
        _profiles.value = _profiles.value + profile
    }

    suspend fun updateProfile(updatedProfile: Profile) {
        _profiles.value = _profiles.value.map {
            if (it.id == updatedProfile.id) updatedProfile else it
        }
    }

    suspend fun removeProfile(profile: Profile) {
        _profiles.value = _profiles.value - profile
    }
}