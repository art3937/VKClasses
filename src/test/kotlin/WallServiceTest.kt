import attachment.*
import comment.Comment
import exception.PostNotFoundException
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    private val post = Post()

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val copyPost = post
        val result: Post = WallService.add(copyPost)
        assertTrue(result.id > 0)
    }

    @Test
    fun update() {
        val copyPost = post.copy()
        assertTrue(WallService.update(WallService.add(copyPost)))
    }

    @Test
    fun updateFalse() {
        val copyPost = post.copy()
        assertFalse(WallService.update(copyPost))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(post)
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
        WallService.createComment(2, Comment())
    }

    @Test
    fun creatCommentTrue() {
        WallService.add(post)
        val result: Comment = WallService.createComment(1, Comment())
        assertTrue(result.id > 0)
    }
}