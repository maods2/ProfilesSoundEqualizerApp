package com.example.profilessoundequalizerapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profilessoundequalizerapp.model.entity.Profile

@Composable
fun NewProfileScreen(
    onProfileCreated: (Profile) -> Unit,
    onNavigateBack: () -> Unit
) {
    var profileName by remember { mutableStateOf("") }
    val newProfile = Profile(name = profileName)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = profileName,
            onValueChange = { profileName = it },
            label = { Text("Profile Name") },
            modifier = Modifier.fillMaxWidth()
        )
        ProfileScreen(
            profile = newProfile,
            onProfileUpdated = onProfileCreated
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { if (profileName.isNotBlank()) onProfileCreated(newProfile) }) {
            Text("Create Profile")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateBack) {
            Text("Cancel")
        }
    }
}