package com.example.profilessoundequalizerapp.viewTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import com.example.profilessoundequalizerapp.model.entity.Profile
import com.example.profilessoundequalizerapp.view.NewProfileScreen
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class NewProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `updates profile name on input change`() {
        composeTestRule.setContent {
            NewProfileScreen(onProfileCreated = {}, onNavigateBack = {})
        }

        composeTestRule.onNodeWithText("Profile Name").performTextInput("Test Profile")
        composeTestRule.onNodeWithText("Test Profile").assertExists()
    }

    @Test
    fun `calls onProfileCreated when Create Profile button is clicked`() {
        val onProfileCreatedMock: (Profile) -> Unit = mock()

        composeTestRule.setContent {
            NewProfileScreen(
                onProfileCreated = onProfileCreatedMock,
                onNavigateBack = {}
            )
        }

        composeTestRule.onNodeWithText("Profile Name").performTextInput("Test Profile")
        composeTestRule.onNodeWithText("Create Profile").performClick()
        verify(onProfileCreatedMock).invoke(Profile(name = "Test Profile"))
    }

    @Test
    fun `calls onNavigateBack when Cancel button is clicked`() {
        val onNavigateBackMock: () -> Unit = mock()

        composeTestRule.setContent {
            NewProfileScreen(
                onProfileCreated = {},
                onNavigateBack = onNavigateBackMock
            )
        }

        composeTestRule.onNodeWithText("Cancel").performClick()
        verify(onNavigateBackMock).invoke()
    }
}
