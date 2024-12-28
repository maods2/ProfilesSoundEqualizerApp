package com.example.profilessoundequalizerapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilessoundequalizerapp.data.dao.ProfileRepository
import com.example.profilessoundequalizerapp.data.model.Profile

@Composable
fun HomeScreen(
    repository: ProfileRepository,
    onCreateNewProfile: () -> Unit,
    onEditProfile: (Profile) -> Unit
) {
    val profiles = repository.profiles.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Create a new sound profile or edit an existing one!",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = onCreateNewProfile, modifier = Modifier.fillMaxWidth()) {
            Text("Create New Profile")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(profiles) { profile ->
                ProfileItem(profile = profile, onClick = { onEditProfile(profile) })
            }
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