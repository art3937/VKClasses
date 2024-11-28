import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class WallServiceTest {

    private val post = Post(
        2, 0, 0, 0,
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
        val copyPost = post
        val result: Post = WallService.add(copyPost)
        assertTrue(result.id>0)

    }

    @Test
    fun update() {
        val copyPost = post
        assertTrue(WallService.update(WallService.add(copyPost)))
    }

    @Test
    fun updateFalse() {
        assertFalse(WallService.update(post))
    }
}