import WallService.posts
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class WallServiceTest {
    private val post = Post(
        999, 0, 0, 0,
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
        post.id = Random.nextInt(+999) + 1
       posts += post
        assertEquals(post.id > 0, posts.last().id > 0)
    }

    @Test
    fun update() {
       posts += post
        assertEquals(true, WallService.update(post))
    }

    @Test
    fun updateFalse() {
        val postReform = post.copy(id = 10)
        assertEquals(true, WallService.update(postReform))
    }
}