import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.profilessoundequalizerapp.model.dao.ProfileDao
import com.example.profilessoundequalizerapp.viewmodel.ProfilesViewModel
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock

class MainActivityTest {

    @Test
    fun `should create ProfilesViewModel using ViewModelProvider Factory`() {
        // Arrange
        val mockDao = mock(ProfileDao::class.java)
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProfilesViewModel(mockDao) as T
            }
        }

        // Act
        val viewModel = factory.create(ProfilesViewModel::class.java)

        // Assert
        assertTrue(viewModel is ProfilesViewModel)
    }
}
