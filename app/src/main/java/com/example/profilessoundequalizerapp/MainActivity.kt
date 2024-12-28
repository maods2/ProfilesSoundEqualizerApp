package com.example.profilessoundequalizerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider

import com.example.profilessoundequalizerapp.ui.components.NavigationSetup
import com.example.profilessoundequalizerapp.ui.theme.ProfilesSoundEqualizerAppTheme
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Instanciando o ProfileRepository
       // val profileRepository = ProfileRepository()
        val profilesViewModel = ViewModelProvider(this)[ProfilesViewModel::class.java]

        setContent {
            ProfilesSoundEqualizerAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavigationSetup(profilesViewModel = profilesViewModel)
                }
            }
        }
    }
}