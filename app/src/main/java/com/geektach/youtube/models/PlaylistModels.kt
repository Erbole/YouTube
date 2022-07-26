package com.geektach.youtube.models

data class Playlist(
    var kind: String,
    var etag: String,
    var items: ArrayList<Items>,
    var pageInfo: PageInfo,
)

data class Thumbnails(
    var default: Default,
    var medium: Medium,
    var high: High
)

data class Snippet(
    var channelId: String,
    var title: String,
    var description: String,
    var thumbnails: Thumbnails,
    var channelTitle: String,
    var tags: List<String>,
    var categoryId: String,
    var liveBroadcastContent: String,
    var localized: Localized,
    val playlistId: String,
    val position: Int,
    val publishedAt: String,
    val resourceId: ResourceId,
    val videoOwnerChannelId: String,
    val videoOwnerChannelTitle: String
)

data class PageInfo(
    var maxResults: Int,
    var totalResults: Int,
    var resultsPerPage: Int = 40
)

data class Medium(
    var url: String,
    var width: Int,
    var height: Int
)

data class Localized(
    var title: String,
    var description: String
)

data class Items(
    var kind: String,
    var etag: String,
    var id: String,
    var snippet: Snippet,
    var contentDetails: ContentDetails
)

data class High(
    var url: String,
    var width: Int,
    var height: Int
)

data class Default(
    var url: String,
    var width: Int,
    var height: Int
)

data class ContentRating(val name: String = "")

data class ContentDetails(
    var itemCount: Int,
    var duration: String,
    var dimension: String,
    var definition: String,
    var caption: String,
    var licensedContent: Boolean,
    var contentRating: ContentRating,
    var projection: String,
    var videoPublishedAt: String
)