package com.geektach.youtube.models

data class PlaylistItems(
    val etag: String,
    val items: ArrayList<Items>,
    val kind: String,
    val pageInfo: PageInfo
)