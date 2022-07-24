package com.geektach.youtube

import android.app.Application
import com.geektach.youtube.remote.Repository
import com.geektach.youtube.remote.RetrofitClient

class App : Application() {
    companion object {
        val youTubeApi = RetrofitClient.provideRetrofit()
        val repository = Repository()
    }
}