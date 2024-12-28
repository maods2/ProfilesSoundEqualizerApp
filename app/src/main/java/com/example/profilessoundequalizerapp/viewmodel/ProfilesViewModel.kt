package com.example.profilessoundequalizerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilessoundequalizerapp.model.dao.ProfileDao

import com.example.profilessoundequalizerapp.model.entity.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfilesViewModel(
    private val dao: ProfileDao
): ViewModel() {

    val _profileDao = dao

    val profileList: LiveData<List<Profile>> = _profileDao.getAllProfiles()


    fun insertProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            _profileDao.upsertProfile(profile)
        }
    }

    fun deleteProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            _profileDao.deleteProfile(profile)
        }
    }
}