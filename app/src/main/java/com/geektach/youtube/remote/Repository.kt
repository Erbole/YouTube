package com.geektach.youtube.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektach.youtube.App
import com.geektach.youtube.BuildConfig
import com.geektach.youtube.core.Constant
import com.geektach.youtube.models.Playlist
import com.geektach.youtube.models.PlaylistItems
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository {

    private val youTubeApi = App.youTubeApi

    fun getPlayLists() = liveData(Dispatchers.IO) {
        val response = youTubeApi.getPlaylists(
            Constant.PART,
            Constant.CHANNEL_ID,
            Constant.MAX_RESULT,
            BuildConfig.API_KEY
        )
        emit(response)
    }

    fun getPlaylistItems(playlistId: String): LiveData<Response<PlaylistItems>> =
        liveData(Dispatchers.IO) {
            val response = youTubeApi.getPlaylistItems(
                Constant.PART,
                BuildConfig.API_KEY,
                Constant.MAX_RESULT,
                playlistId
            )
            emit(response)
        }
}