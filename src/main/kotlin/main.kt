fun main() {
    val reposts: Reposts? = null
    val post = Post(
        0, 0, 0, 0, "text", false, 0, false,reposts
    )
    println(WallService.add(post).reposts)
    println(WallService.update(post))
}

 data class Post(
    var id: Int, val fromId: Int, //Идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy: Int, //Идентификатор администратора, который опубликовал запись
    val replyOwnerId: Int, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val text: String, val friendsOnly: Boolean, //1, если запись была создана с опцией «Только для друзей».
    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая
    val canDelete: Boolean, //Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может)
    val reposts: Reposts?
)

object WallService {
    private var posts = emptyArray<Post>() // массив с постами
    private var count = 0
    fun add(post: Post): Post {
        count++
        val copyPost = post.copy(id = count)
        posts += copyPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var result = false
        val copyPost = post.copy()
        for ((index, anotherPost) in posts.withIndex()) {
            if (copyPost.id == anotherPost.id) {
                posts[index] = copyPost
                result = true
            }
        }
        return result
    }

    fun clear() {
        posts = emptyArray()
        count = 0
        // также здесь нужно сбросить счетчик для id постов, если он у вас используется
    }
}

class Reposts(
    val count: Int, //число пользователей, скопировавших запись;
    val userReposted: Boolean)  //наличие репоста от текущего пользователя (1 — есть, 0 — нет)
    {
//Логика
}
