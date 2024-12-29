package com.example.profilessoundequalizerapp.uiTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.profilessoundequalizerapp.SoundProfileManager
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.ui.components.NavigationSetup
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class NavigationSetupTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockProfilesViewModel = mock(ProfilesViewModel::class.java)
    private val mockSoundProfileManager = mock(SoundProfileManager::class.java)

    @Test
    fun `should start at HomeScreen`() {
        // Arrange & Act
        composeTestRule.setContent {
            NavigationSetup(
                profilesViewModel = mockProfilesViewModel,
                soundProfileManager = mockSoundProfileManager
            )
        }

        // Assert
        composeTestRule.onNodeWithText("Home").assertExists()
    }

    @Test
    fun `should navigate to NewProfileScreen`() {
        // Arrange & Act
        composeTestRule.setContent {
            NavigationSetup(
                profilesViewModel = mockProfilesViewModel,
                soundProfileManager = mockSoundProfileManager
            )
        }

        // Navigate to New Profile
        composeTestRule.onNodeWithText("Create New Profile").performClick()

        // Assert
        composeTestRule.onNodeWithText("New Profile").assertExists()
    }

    @Test
    fun `should call ViewModel and SoundProfileManager on profile creation`() {
        // Arrange & Act
        composeTestRule.setContent {
            NavigationSetup(
                profilesViewModel = mockProfilesViewModel,
                soundProfileManager = mockSoundProfileManager
            )
        }

        // Navigate to New Profile
        composeTestRule.onNodeWithText("Create New Profile").performClick()

        // Simulate profile creation
        val mockProfile = mock(Profile::class.java)
        doNothing().`when`(mockProfilesViewModel).insertProfile(mockProfile)
        doNothing().`when`(mockSoundProfileManager).updateProfile(mockProfile)

        // Assert
        verify(mockProfilesViewModel).insertProfile(mockProfile)
        verify(mockSoundProfileManager).updateProfile(mockProfile)
    }
}
