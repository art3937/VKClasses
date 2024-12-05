package attachment

import comment.Comment
import exception.PostNotFoundException

fun main() {

    val reposts: Reposts? = null
    val video = VideoAttachment(Video(10, 20, "vkvideo", 10))
    val photo = PhotoAttachment(Photo(5, 6, "gddng", "fgnffh"))
    val file = FileAttachment(File(5, 10, "FileName", 255))
    val image = ImageAttachment(Image())
    val doc = DocAttachment(Doc())
    AttachmentService.add(doc)
    AttachmentService.add(photo)
    AttachmentService.add(file)
    AttachmentService.add(image)
    val attachmentArray = AttachmentService.add(video)
    val post = Post()
    println(WallService.add(post))
    println(WallService.update(post))
   println(WallService.createComment(1, Comment(attachment = AttachmentService.attachment)))
}

object AttachmentService {
    var attachment = emptyArray<Attachment>()
    fun add(content: Attachment): Array<Attachment> {
        attachment += content
        return attachment
    }
}

data class Post(
    var id: Int = 0,
    val fromId: Int = 0, //Идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy: Int = 0, //Идентификатор администратора, который опубликовал запись
    val replyOwnerId: Int = 0, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val text: String = "",
    val friendsOnly: Boolean = false, //1, если запись была создана с опцией «Только для друзей».
    val replyPostId: Int = 0, //Идентификатор записи, в ответ на которую была оставлена текущая
    val canDelete: Boolean = false, //Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может)
    val reposts: Reposts? = Reposts(),
    val attachment: Array<Attachment>? = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Post
        return attachment.contentEquals(other.attachment)
    }

    override fun hashCode(): Int {
        return attachment.contentHashCode()
    }
}

object WallService {
    private var comments = emptyArray<Comment>()
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

    fun createComment(postId: Int, comment: Comment): Comment {
        var commentLast: Comment? = null
        for ((index, anotherPost) in posts.withIndex()) {
            if (postId == anotherPost.id) {
               comments += comment
              commentLast = comments.last()
            }
        }
            return commentLast ?: throw PostNotFoundException("Ид не найден")
    }

    fun clear() {
        posts = emptyArray()
        count = 0
        comments = emptyArray()
        // также здесь нужно
        // сбросить счетчик для id постов, если он у вас используется
    }
}

class Reposts(
    val count: Int = 0, //число пользователей, скопировавших запись;
    val userReposted: Boolean = false
)  //наличие репоста от текущего пользователя (1 — есть, 0 — нет)
{
//Логика
}

