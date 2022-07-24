package com.geektach.youtube.ui.play_list_videos

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektach.youtube.models.PlaylistItems
import com.geektach.youtube.remote.Repository
import retrofit2.Response

class PlaylistItemsViewModel(private val repository: Repository) : ViewModel() {

    fun getPlayListItems(playlistId: String): LiveData<Response<PlaylistItems>> {
        return repository.getPlaylistItems(playlistId)
    }
}