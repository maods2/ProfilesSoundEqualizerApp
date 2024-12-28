package com.example.profilessoundequalizerapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.profilessoundequalizerapp.model.dao.ProfileRepository
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel

@Composable
fun HomeScreen(
    profilesViewModel: ProfilesViewModel,
    onCreateNewProfile: () -> Unit,
    onEditProfile: (Profile) -> Unit
) {
    val profiles = profilesViewModel.profileList.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // Ajuste o padding inferior conforme necessário
        ) {
            Text(
                text = "Create a new sound profile or edit an existing one!",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp, top = 25.dp)
            )

            profiles?.let { nonNullProfiles ->
                LazyColumn {
                    items(nonNullProfiles) { profile ->
                        ProfileItem(profile = profile, onClick = { onEditProfile(profile) })
                    }
                }
            }
        }

        Button(
            onClick = onCreateNewProfile,
            modifier = Modifier
                .align(Alignment.BottomCenter) // Alinha o botão ao fundo centralizado
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Create New Profile")
        }
    }
}

@Composable
fun ProfileItem(profile: Profile, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = profile.name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }
}