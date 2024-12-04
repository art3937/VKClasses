package comment

import attachment.Attachment

data class Comment(
    val id: Int = 2,
    val fromInt: Int = 0, // Идентификатор автора комментария.
    val date: Int = 0, //Дата создания комментария в формате
    val text: String = "",//Текст комментария.
    val donut: Donut = Donut(),
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachment: Array<Attachment>? = emptyArray(),
    val thread: Thread = Thread()
)

data class Donut(
    val isDon: Boolean = false, //является ли комментатор подписчиком VK Donut.
    val placeholder: String = " " //заглушка для пользователей, которые не оформили подписку VK Donut.
)

class Thread(
    val count: Int = 0, //(integer) — количество комментариев в ветке.
    val items: Array<Any> = emptyArray(),// (array) — массив объектов комментариев к записи (только для метода wall.getComments).
    val canPost: Boolean = false, // может ли текущий пользователь оставлять комментарии в этой ветке.
    val showReplyButton: Boolean = false, //нужно ли отображать кнопку «ответить» в ветке.
    val groupsCanPost: Boolean = false //могут ли сообщества оставлять комментарии в ветке.
)