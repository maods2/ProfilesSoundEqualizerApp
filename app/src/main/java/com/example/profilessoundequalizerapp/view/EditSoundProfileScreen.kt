package com.example.profilessoundequalizerapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.ui.components.SoundProfileComponent

@Composable
fun EditSoundProfileScreen(
    profile: Profile,
    onProfileUpdated:  (Profile) -> Unit,
    onNavigateBack: () -> Unit
) {
    var name by remember { mutableStateOf(profile.name) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Profile Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        SoundProfileComponent(
            profile = profile,
            onProfileUpdated = onProfileUpdated
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onProfileUpdated(profile.copy(name = name)) }) {
            Text("Save Changes")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateBack) {
            Text("Cancel")
        }
    }
}