package com.geektach.youtube.ui.play_list_videos

import com.geektach.youtube.core.BaseActivity
import com.geektach.youtube.databinding.ActivityPlayListVideosBinding
import com.geektach.youtube.extencions.gone
import com.geektach.youtube.extencions.visible
import com.geektach.youtube.models.Items
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListVideosActivity : BaseActivity<ActivityPlayListVideosBinding>() {

    private val viewModel: PlaylistItemsViewModel by viewModel()
    private var videos: ArrayList<Items>? = arrayListOf()
    private val playlistsVideosAdapter by lazy { videos?.let { PlaylistVideosAdapter(it) } }

    override fun inflateViewBinding(): ActivityPlayListVideosBinding {
        return ActivityPlayListVideosBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        val playlistId = intent.getStringExtra("id")
        binding.progressBarr.visible()
        if (playlistId != null)
            viewModel.getPlayListItems(playlistId).observe(this) {
                if (it.isSuccessful && it.body() != null) {
                    binding.progressBarr.gone()
                    videos = it.body()?.items
                    binding.rvVideo.adapter = playlistsVideosAdapter
                    binding.tvPlaylistTitle.text = intent.getStringExtra("title")
                    binding.tvPlaylistDesc.text = intent.getStringExtra("description")
                }
            }
    }

    override fun chekInternet() {

    }

    override fun setUI() {
    }

    override fun initClick() {
    }
}