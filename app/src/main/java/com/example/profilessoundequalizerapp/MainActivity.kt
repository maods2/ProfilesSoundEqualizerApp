package com.example.profilessoundequalizerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.profilessoundequalizerapp.model.dao.SoundProfileDatabase

import com.example.profilessoundequalizerapp.ui.components.NavigationSetup
import com.example.profilessoundequalizerapp.ui.theme.ProfilesSoundEqualizerAppTheme
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel

class MainActivity : ComponentActivity() {


    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            SoundProfileDatabase::class.java,
            SoundProfileDatabase.NAME
        ).build()
    }

    private val viewModel by viewModels<ProfilesViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ProfilesViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ProfilesSoundEqualizerAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavigationSetup(profilesViewModel = viewModel)
                }
            }
        }
    }
}