import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class WallServiceTest {

@Before
fun clearBeforeTest() {
 WallService.clear()
}

@Test
 fun add(){
 var posts = emptyArray<Post>()
 val post = Post(999, 0, 0, 0, "text", false, 0, false)
 post.id = Random.nextInt(+999) + 1
 posts += post
 assertEquals(post.id>0,posts.last().id>0)
 }

@Test
 fun update() {
 var posts = emptyArray<Post>()
 posts +=  Post(999, 0, 0, 0, "text", false, 0, false)
 val post = Post(999, 0, 0, 0, "text", false, 0, false)
 var result = false
 for ((index, anotherPost) in posts.withIndex()) {
  if (post.id == anotherPost.id) {
   posts[index] = post.copy(text = "изменил")
   result = true
   println(posts[index])
  }
 }
 assertEquals(true,result)
}

 @Test
 fun updateFalse() {
  var posts = emptyArray<Post>()
  posts +=  Post(0, 0, 0, 0, "text", false, 0, false)
  val post = Post(999, 0, 0, 0, "text", false, 0, false)
  var result = false
  for ((index, anotherPost) in posts.withIndex()) {
   if (post.id == anotherPost.id) {
    posts[index] = post.copy(text = "изменил")
    result = true
    println(posts[index])
   }
  }
  assertEquals(false,result)
 }
}