import android.content.Context
import androidx.room.Room
import com.example.profilessoundequalizerapp.model.dao.SoundProfileDatabase
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock

class DatabaseTest {

    @Test
    fun `should initialize database with DAO`() {
        // Arrange
        val mockContext = mock(Context::class.java)

        // Act
        val db = Room.inMemoryDatabaseBuilder(
            mockContext,
            SoundProfileDatabase::class.java
        ).build()

        // Assert
        assertNotNull(db.dao)
    }
}
