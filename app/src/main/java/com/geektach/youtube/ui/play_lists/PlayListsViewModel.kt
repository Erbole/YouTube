package com.geektach.youtube.ui.play_lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektach.youtube.models.Playlist
import com.geektach.youtube.remote.Repository
import retrofit2.Response

class PlayListsViewModel(private val repository: Repository) : ViewModel() {

    fun getPlayLists(): LiveData<Response<Playlist>> {
        return repository.getPlayLists()
    }

}