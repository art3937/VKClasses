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
    private var posts = emptyArray<Post>()
    private var count = 0

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val copyPost = post
      posts += WallService.add(copyPost)
        assertTrue(posts.last().id>0)

    }

    @Test
    fun update() {
        assertTrue(WallService.update(WallService.add(post)))
    }

    @Test
    fun updateFalse() {
        assertFalse(WallService.update(post))
    }
}