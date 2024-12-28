package com.example.profilessoundequalizerapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profilessoundequalizerapp.model.dao.ProfileRepository
import com.example.profilessoundequalizerapp.view.EditSoundProfileScreen
import com.example.profilessoundequalizerapp.view.HomeScreen
import com.example.profilessoundequalizerapp.view.NewProfileScreen
import kotlinx.coroutines.runBlocking

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun NavigationSetup(profileRepository: ProfileRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        // Home Screen
        composable("home") {
            HomeScreen(
                repository = profileRepository,
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
                    // Usando LaunchedEffect para chamar função suspensa
                    runBlocking {
                        profileRepository.addProfile(profile)  // Função suspensa chamada aqui
                        navController.popBackStack() // Voltar para a tela inicial
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        // Edit Profile Screen
        composable("edit/{profileId}") { backStackEntry ->
            val profileId = backStackEntry.arguments?.getInt("profileId") ?: 0
            val profile = profileRepository.profiles.value.firstOrNull { it.id == profileId }
            if (profile != null) {
                EditSoundProfileScreen(
                    profile = profile,
                    onProfileUpdated = { updatedProfile ->
                        // Atualiza o repositório com os valores atualizados
                        runBlocking{
                            profileRepository.updateProfile(updatedProfile)
                            navController.popBackStack()
                        }
                    },
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}