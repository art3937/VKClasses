import attachment.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    private val post = Post(
        2, 0, 0, 0,
        "text", false, 0,
        false, Reposts(
            2, false
        ), AttachmentService.add(Photo(1, 2, "", ""))
    )

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val copyPost = post
        val result: Post = WallService.add(copyPost)
<<<<<<< HEAD
        assertTrue(result.id>0)
=======
        assertTrue(result.id > 0)
>>>>>>> MyAttachment

    }

    @Test
    fun update() {
<<<<<<< HEAD
        val copyPost = post
=======
        val copyPost = post.copy()
>>>>>>> MyAttachment
        assertTrue(WallService.update(WallService.add(copyPost)))
    }

    @Test
    fun updateFalse() {
        val copyPost = post.copy()
        assertFalse(WallService.update(copyPost))
    }
}