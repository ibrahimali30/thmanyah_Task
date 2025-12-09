package com.ibrahim.thmanyahTask.home.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResult(
    val pagination: Pagination,
    val sections: List<SectionResponse>,
)

@Serializable
data class SectionResponse(
    val name: String,
    val type: SectionType,
    @SerialName("content_type")
    val contentType: ContentType,
    val order: Int,
    val content: List<ContentItem>,
)

@Serializable
data class Pagination(
    @SerialName("next_page")
    val nextPage: String?,
    @SerialName("total_pages")
    val totalPages: Int,
)

@Serializable
enum class SectionType(val key: String) {
    @SerialName("square")
    SQUARE("square"),

    @SerialName("2_lines_grid")
    TWO_LINES_GRID("2_lines_grid"),

    @SerialName("big_square")
    BIG_SQUARE("big_square"),

    @SerialName("big square")
    BIG_SQUARE2("big_square"),

    @SerialName("queue")
    QUEUE("queue"),
    ;

    companion object {
        fun fromKey(key: String): SectionType? = entries.find { it.key == key }
    }
}

@Serializable
enum class ContentType(val key: String) {
    @SerialName("podcast")
    PODCAST("podcast"),

    @SerialName("episode")
    EPISODE("episode"),

    @SerialName("audio_book")
    AUDIO_BOOK("audio_book"),

    @SerialName("audio_article")
    AUDIO_ARTICLE("audio_article"),

    @SerialName("social_comment")
    SOCIAL_COMMENT("social_comment"),
    ;

    companion object {
        fun fromKey(key: String): ContentType? = entries.find { it.key == key }
    }
}


@Serializable
data class ContentItem(
    // Common fields
    val name: String,
    val description: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    val duration: Long,
    val score: Double,
    // Optional fields for different content types
    @SerialName("podcast_id")
    val podcastId: String? = null,
    @SerialName("episode_count")
    val episodeCount: Int? = null,
    val language: String? = null,
    val priority: Int? = null,
    @SerialName("popularityScore")
    val popularityScore: Int? = null,
    @SerialName("episode_id")
    val episodeId: String? = null,
    @SerialName("season_number")
    val seasonNumber: Int? = null,
    @SerialName("episode_type")
    val episodeType: String? = null,
    @SerialName("podcast_name")
    val podcastName: String? = null,
    @SerialName("author_name")
    val authorName: String? = null,
    val number: Int? = null,
    @SerialName("separated_audio_url")
    val separatedAudioUrl: String? = null,
    @SerialName("audio_url")
    val audioUrl: String? = null,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("audiobook_id")
    val audiobookId: String? = null,
    @SerialName("article_id")
    val articleId: String? = null,
    @SerialName("podcastPopularityScore")
    val podcastPopularityScore: Int? = null,
    @SerialName("podcastPriority")
    val podcastPriority: Int? = null,
    val chapters: List<Chapter> = emptyList(),
    @SerialName("paid_is_early_access")
    val paidIsEarlyAccess: Boolean = false,
    @SerialName("paid_is_now_early_access")
    val paidIsNowEarlyAccess: Boolean = false,
    @SerialName("paid_is_exclusive")
    val paidIsExclusive: Boolean = false,
    @SerialName("paid_transcript_url")
    val paidTranscriptUrl: String? = null,
    @SerialName("free_transcript_url")
    val freeTranscriptUrl: String? = null,
    @SerialName("paid_is_exclusive_partially")
    val paidIsExclusivePartially: Boolean = false,
    @SerialName("paid_exclusive_start_time")
    val paidExclusiveStartTime: Int = 0,
    @SerialName("paid_early_access_date")
    val paidEarlyAccessDate: String? = null,
    @SerialName("paid_early_access_audio_url")
    val paidEarlyAccessAudioUrl: String? = null,
    @SerialName("paid_exclusivity_type")
    val paidExclusivityType: String? = null,
)

@Serializable
data class Chapter(
    val title: String,
    @SerialName("start_time")
    val startTime: Int,
)