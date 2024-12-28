package com.example.profilessoundequalizerapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profilessoundequalizerapp.model.entity.Profile

@Composable
fun ProfileScreen(
    profile: Profile,
    onProfileUpdated: (Profile) -> Unit,
    onNavigateBack: () -> Unit
) {
    var bass by remember { mutableStateOf(profile.bass) }
    var mid by remember { mutableStateOf(profile.mid) }
    var high by remember { mutableStateOf(profile.high) }
    var volume by remember { mutableStateOf(profile.volume) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Adjust Sound Settings", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        // Bass Slider
        Text(text = "Bass: ${"%.2f".format(bass)}", style = MaterialTheme.typography.bodySmall)
        Slider(
            value = bass,
            onValueChange = { bass = it },
            valueRange = 0f..1f,
            steps = 10,
            modifier = Modifier.fillMaxWidth()
        )

        // Mid Slider
        Text(text = "Mid: ${"%.2f".format(mid)}", style = MaterialTheme.typography.bodySmall)
        Slider(
            value = mid,
            onValueChange = { mid = it },
            valueRange = 0f..1f,
            steps = 10,
            modifier = Modifier.fillMaxWidth()
        )

        // High Slider
        Text(text = "High: ${"%.2f".format(high)}", style = MaterialTheme.typography.bodySmall)
        Slider(
            value = high,
            onValueChange = { high = it },
            valueRange = 0f..1f,
            steps = 10,
            modifier = Modifier.fillMaxWidth()
        )

        // Volume Slider
        Text(text = "Volume: ${"%.2f".format(volume)}", style = MaterialTheme.typography.bodySmall)
        Slider(
            value = volume,
            onValueChange = { volume = it },
            valueRange = 0f..1f,
            steps = 10,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onProfileUpdated(
                profile.copy(bass = bass, mid = mid, high = high, volume = volume)
            )
        }) {
            Text("Save Changes")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateBack) {
            Text("Cancel")
        }
    }
}