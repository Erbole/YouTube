package com.geektach.youtube.di

import com.geektach.youtube.ui.play_list_videos.PlaylistItemsViewModel
import com.geektach.youtube.ui.play_lists.PlayListsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { PlayListsViewModel(get()) }
    viewModel { PlaylistItemsViewModel(get()) }
}