package com.example.profilessoundequalizerapp.uiTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.ui.components.SoundProfileComponent
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SoundProfileComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `renders initial values correctly`() {
        // Arrange
        val initialProfile = Profile(
            id = 1,
            name = "Test Profile",
            bass = 0.5f,
            mid = 0.6f,
            high = 0.7f,
            volume = 0.8f
        )

        // Act
        composeTestRule.setContent {
            SoundProfileComponent(profile = initialProfile, onProfileUpdated = {})
        }

        // Assert
        composeTestRule.onNodeWithText("Bass: 0.50").assertExists()
        composeTestRule.onNodeWithText("Mid: 0.60").assertExists()
        composeTestRule.onNodeWithText("High: 0.70").assertExists()
        composeTestRule.onNodeWithText("Volume: 0.80").assertExists()
    }

    @Test
    fun `sliders update their values`() {
        // Arrange
        val initialProfile = Profile(
            id = 1,
            name = "Test Profile",
            bass = 0.5f,
            mid = 0.6f,
            high = 0.7f,
            volume = 0.8f
        )

        // Act
        composeTestRule.setContent {
            SoundProfileComponent(profile = initialProfile, onProfileUpdated = {})
        }

        // Interact with Bass Slider
        composeTestRule.onNodeWithText("Bass: 0.50").performTouchInput {
            swipeRight()
        }

        // Assert updated value
        composeTestRule.onNodeWithText("Bass: 1.00").assertExists()
    }

    @Test
    fun `save button triggers onProfileUpdated with correct values`() {
        // Arrange
        val initialProfile = Profile(
            id = 1,
            name = "Test Profile",
            bass = 0.5f,
            mid = 0.6f,
            high = 0.7f,
            volume = 0.8f
        )

        val onProfileUpdatedMock: (Profile) -> Unit = mock()

        // Act
        composeTestRule.setContent {
            SoundProfileComponent(profile = initialProfile, onProfileUpdated = onProfileUpdatedMock)
        }

        // Interact with sliders
        composeTestRule.onNodeWithText("Bass: 0.50").performTouchInput {
            swipeRight()
        }
        composeTestRule.onNodeWithText("Volume: 0.80").performTouchInput {
            swipeLeft()
        }

        // Click Save
        composeTestRule.onNodeWithText("Save Changes").performClick()

        // Assert callback
        verify(onProfileUpdatedMock).invoke(
            initialProfile.copy(bass = 1.0f, mid = 0.6f, high = 0.7f, volume = 0.0f)
        )
    }
}
