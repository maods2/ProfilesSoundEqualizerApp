package com.example.profilessoundequalizerapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profilessoundequalizerapp.view.EditSoundProfileScreen
import com.example.profilessoundequalizerapp.view.HomeScreen
import com.example.profilessoundequalizerapp.view.NewProfileScreen
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel
import kotlinx.coroutines.runBlocking

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavigationSetup(profilesViewModel: ProfilesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        // Home Screen
        composable("home") {
            HomeScreen(
                profilesViewModel = profilesViewModel,
                onCreateNewProfile = { navController.navigate("new_profile") },
                onEditProfile = { profile ->
                    navController.navigate("edit/${profile.id}")
                }
            )
        }

        // New Profile Screen
        composable("new_profile") {
            NewProfileScreen(
                onProfileCreated = { profile ->
                        profilesViewModel.insertProfile(profile)
                        navController.popBackStack()
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Edit Profile Screen
        composable("edit/{profileId}") { backStackEntry ->
            val profileId = backStackEntry.arguments?.getInt("profileId") ?: 0
            val profile = profilesViewModel.profileList.value?.firstOrNull { it.id == profileId }
            if (profile != null) {
                EditSoundProfileScreen(
                    profile = profile,
                    onProfileUpdated = { updatedProfile ->
                        runBlocking{
                            profilesViewModel.insertProfile(updatedProfile)
                            navController.popBackStack()
                        }
                    },
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}