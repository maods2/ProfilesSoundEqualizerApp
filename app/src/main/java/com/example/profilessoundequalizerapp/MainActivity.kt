package com.example.profilessoundequalizerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.profilessoundequalizerapp.data.dao.ProfileRepository

import com.example.profilessoundequalizerapp.ui.components.NavigationSetup
import com.example.profilessoundequalizerapp.ui.theme.ProfilesSoundEqualizerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instanciando o ProfileRepository
        val profileRepository = ProfileRepository()

        setContent {
            ProfilesSoundEqualizerAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Passando o profileRepository para o NavigationSetup
                    NavigationSetup(profileRepository = profileRepository)
                }
            }
        }
    }
}