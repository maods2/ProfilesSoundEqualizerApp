package com.example.profilessoundequalizerapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profilessoundequalizerapp.data.model.Profile

@Composable
fun NewProfileScreen(onProfileCreated: (Profile) -> Unit, onNavigateBack: () -> Unit) {
    var profileName by remember { mutableStateOf("") }

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
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { if (profileName.isNotBlank()) onProfileCreated(Profile(name = profileName)) }) {
            Text("Create Profile")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateBack) {
            Text("Cancel")
        }
    }
}