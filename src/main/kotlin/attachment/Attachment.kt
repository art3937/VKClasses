package attachment
interface Attachment {
    val type: String
}

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val duration: Int = 0,
) : Attachment{
    override val type: String = "video"
}

data class Photo(
    val id: Int = 0,
    val ownerId: Int =0,
    val photo604: String = "",
    val photo130: String = "",

    ) : Attachment{
    override val type: String = "photo"

}

data class PhotoAttachment(
    val photo: Photo = Photo()
): Attachment{
    override val type: String = "photo"
}

data class VideoAttachment(
    val video: Video = Video()
): Attachment{
    override val type: String = "video"
}