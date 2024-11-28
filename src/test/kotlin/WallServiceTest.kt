import WallService.posts
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class WallServiceTest {
    private val post = Post(
        0, 0, 0, 0,
        "text", false, 0,
        false, Reposts(
            2, false
        )
    )

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        posts += post
        posts.last().id++
        assertTrue(posts.last().id > 0)
    }

    @Test
    fun update() {
        posts += post
        assertTrue(WallService.update(post))
    }

    @Test
    fun updateFalse() {
        assertFalse(WallService.update(post))
    }
}