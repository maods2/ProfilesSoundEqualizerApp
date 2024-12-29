import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.profilessoundequalizerapp.SoundProfileManager
import com.example.profilessoundequalizerapp.ui.components.NavigationSetup
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `should render NavigationSetup`() {
        composeTestRule.setContent {
            NavigationSetup(
                profilesViewModel = mock(ProfilesViewModel::class.java),
                soundProfileManager = mock(SoundProfileManager::class.java)
            )
        }

        // Assert UI elements here using composeTestRule
    }
}
