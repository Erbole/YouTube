package com.geektach.youtube.ui.play_lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektach.youtube.App
import com.geektach.youtube.models.Playlist
import retrofit2.Response

class PlayListsViewModel : ViewModel() {

    fun getPlayLists(): LiveData<Response<Playlist>> {
        return App.repository.getPlayLists()
    }

}