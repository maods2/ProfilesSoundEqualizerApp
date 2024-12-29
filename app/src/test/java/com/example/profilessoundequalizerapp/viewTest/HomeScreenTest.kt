package com.example.profilessoundequalizerapp.viewTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import androidx.lifecycle.liveData
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.view.HomeScreen
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `renders list of profiles`() {
        val profiles = listOf(
            Profile(id = 1, name = "Profile 1"),
            Profile(id = 2, name = "Profile 2")
        )
        val viewModel = mock<ProfilesViewModel>().apply {
            whenever(profileList).thenReturn(liveData { emit(profiles) })
        }

        composeTestRule.setContent {
            HomeScreen(
                profilesViewModel = viewModel,
                onCreateNewProfile = {},
                onEditProfile = {}
            )
        }

        composeTestRule.onNodeWithText("Profile 1").assertExists()
        composeTestRule.onNodeWithText("Profile 2").assertExists()
    }

    @Test
    fun `calls onCreateNewProfile when Create New Profile button is clicked`() {
        val onCreateNewProfileMock: () -> Unit = mock()

        composeTestRule.setContent {
            HomeScreen(
                profilesViewModel = mock(),
                onCreateNewProfile = onCreateNewProfileMock,
                onEditProfile = {}
            )
        }

        composeTestRule.onNodeWithText("Create New Profile").performClick()
        verify(onCreateNewProfileMock).invoke()
    }

    @Test
    fun `calls onEditProfile when profile item is clicked`() {
        val profiles = listOf(Profile(id = 1, name = "Profile 1"))
        val viewModel = mock<ProfilesViewModel>().apply {
            whenever(profileList).thenReturn(liveData { emit(profiles) })
        }
        val onEditProfileMock: (Profile) -> Unit = mock()

        composeTestRule.setContent {
            HomeScreen(
                profilesViewModel = viewModel,
                onCreateNewProfile = {},
                onEditProfile = onEditProfileMock
            )
        }

        composeTestRule.onNodeWithText("Profile 1").performClick()
        verify(onEditProfileMock).invoke(profiles[0])
    }
}
