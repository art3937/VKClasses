package attachment

interface Attachment {
    val type: String
}

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val duration: Int = 0,
)

data class Photo(
    val id: Int = 0,
    val ownerId: Int = 0,
    val photo604: String = "",
    val photo130: String = "",
)

data class File(
    val id: Int = 0, //ид файла
    val ownerId: Int = 0,//пользователь загрузивший файл
    val title: String = "",
    val size: Int = 0, // размер в байтах
    val ext: Int = 0
)

data class FileAttachment(
    val file: File = File()
) : Attachment {
    override val type: String = "file"
}

data class PhotoAttachment(
    val photo: Photo = Photo(),
) : Attachment {
    override val type: String = "photo"
}

data class VideoAttachment(
    val video: Video = Video(),
) : Attachment {
    override val type: String = "video"
}

class Image(
    val numbers: Array<Any> = arrayOf(
        0, // высота изображения.
        "", // ссылка на изображение.
        0, //ширина изображения.
        0
    ) //поле возвращается, если изображение с отбивкой, всегда содержит 1.
)

data class ImageAttachment(
    val image: Image = Image()
) : Attachment {
    override val type: String = "image"
}

data class Doc(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0
)

data class DocAttachment(
    val doc: Doc = Doc()
) : Attachment {
    override val type: String = "doc"
}