package com.example.profilessoundequalizerapp.viewTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.view.EditSoundProfileScreen
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class EditSoundProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `renders initial profile data correctly`() {
        val profile = Profile(id = 1, name = "Test Profile", bass = 0.5f, mid = 0.6f, high = 0.7f, volume = 0.8f)

        composeTestRule.setContent {
            EditSoundProfileScreen(
                profile = profile,
                onProfileUpdated = {},
                onNavigateBack = {}
            )
        }

        composeTestRule.onNodeWithText("Test Profile").assertExists()
    }

    @Test
    fun `updates profile name on input change`() {
        val profile = Profile(id = 1, name = "Test Profile", bass = 0.5f, mid = 0.6f, high = 0.7f, volume = 0.8f)

        composeTestRule.setContent {
            EditSoundProfileScreen(
                profile = profile,
                onProfileUpdated = {},
                onNavigateBack = {}
            )
        }

        composeTestRule.onNodeWithText("Profile Name").performTextInput(" Updated")
        composeTestRule.onNodeWithText("Test Profile Updated").assertExists()
    }

    @Test
    fun `calls onProfileUpdated when Save Changes is clicked`() {
        val profile = Profile(id = 1, name = "Test Profile", bass = 0.5f, mid = 0.6f, high = 0.7f, volume = 0.8f)
        val onProfileUpdatedMock: (Profile) -> Unit = mock()

        composeTestRule.setContent {
            EditSoundProfileScreen(
                profile = profile,
                onProfileUpdated = onProfileUpdatedMock,
                onNavigateBack = {}
            )
        }

        composeTestRule.onNodeWithText("Save Changes").performClick()
        verify(onProfileUpdatedMock).invoke(profile)
    }
}
