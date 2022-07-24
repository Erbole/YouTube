package com.geektach.youtube.ui.play_list_videos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektach.youtube.App
import com.geektach.youtube.models.Playlist
import com.geektach.youtube.models.PlaylistItems
import retrofit2.Response

class PlaylistItemsViewModel : ViewModel() {

    fun getPlayListItems(playlistId: String): LiveData<Response<PlaylistItems>> {
        return App.repository.getPlaylistItems(playlistId)
    }
}