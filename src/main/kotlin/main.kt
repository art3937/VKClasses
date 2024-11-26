import kotlin.random.Random

fun main() {

    val post = Post(0, 0, 0, 0, "text", false, 0, false)
    val reposts = Reposts(10, false)
    val init = post.copy(text = "Hello Netology")
    //println(init)
    println(WallService.add(post))
    println(WallService.update(post))
    println(post)

}

data class Post(
    var id: Int, val fromId: Int, //Идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy: Int, //Идентификатор администратора, который опубликовал запись
    val replyOwnerId: Int, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val text: String, val friendsOnly: Boolean, //1, если запись была создана с опцией «Только для друзей».
    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая
    val canDelete: Boolean //Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может)
)

object WallService {
    private var posts = emptyArray<Post>() // массив с постами
    fun add(post: Post): Post {
        post.id = Random.nextInt(+999)+1
        posts += post
        return post
    }

    fun update(post: Post): Boolean {
        var result = false
        for ((index, anotherPost) in posts.withIndex()) {
            if (post.id == anotherPost.id) {
                posts[index] = post.copy(text = "изменил")
                result = true
                println(posts[index])
            }
        }
        return result
    }

    fun clear() {
        posts = emptyArray()
        // также здесь нужно сбросить счетчик для id постов, если он у вас используется
    }
}

class Reposts(
    val count: Int, //число пользователей, скопировавших запись;
    val userReposted: Boolean  //наличие репоста от текущего пользователя (1 — есть, 0 — нет).
) {
//Логика
}
