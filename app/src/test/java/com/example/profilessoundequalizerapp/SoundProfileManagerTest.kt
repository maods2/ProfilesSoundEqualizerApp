import android.content.Context
import com.example.profilessoundequalizerapp.SoundProfileManager
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock

class SoundProfileManagerTest {

    @Test
    fun `should initialize SoundProfileManager`() {
        // Arrange
        val mockContext = mock(Context::class.java)

        // Act
        val soundProfileManager = SoundProfileManager(mockContext)

        // Assert
        assertNotNull(soundProfileManager)
    }
}
