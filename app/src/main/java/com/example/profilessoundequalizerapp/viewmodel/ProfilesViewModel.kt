package com.example.profilessoundequalizerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilessoundequalizerapp.MainApplication

import com.example.profilessoundequalizerapp.model.entity.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfilesViewModel(): ViewModel() {

    val _profileDao = MainApplication.soundProfilesDB.getProfileDao()


    val profileList: LiveData<List<Profile>> = _profileDao.getAllProfiles()


    fun insertProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            _profileDao.addProfile(profile)
        }
    }

    fun deleteProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            _profileDao.deleteProfile(profile)
        }
    }
}