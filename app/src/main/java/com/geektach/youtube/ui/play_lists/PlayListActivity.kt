package com.geektach.youtube.ui.play_lists

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.geektach.youtube.core.BaseActivity
import com.geektach.youtube.databinding.ActivityPlaylistsBinding
import com.geektach.youtube.models.Items
import com.geektach.youtube.ui.play_list_videos.PlayListVideosActivity

class PlayListActivity : BaseActivity<ActivityPlaylistsBinding>(), ItemClickListener {

    private val viewModel by lazy {
        ViewModelProvider(this)[PlayListsViewModel::class.java]
    }
    private var playlists: ArrayList<Items>? = arrayListOf()
    private val playlistsAdapter by lazy {
        playlists?.let { PlayListsAdapter(it) }
    }

    override fun inflateViewBinding(): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(layoutInflater)
    }

    override fun chekInternet() {
    }

    override fun initViewModel() {
        viewModel.getPlayLists().observe(this) {
            if (it.body() != null) {
                playlists = it.body()?.items
            }
            playlistsAdapter?.setListener(this)
            binding.rvPlaylists.adapter = playlistsAdapter
        }
    }

    override fun setUI() {
    }

    override fun initClick() {
    }

    override fun onItemClick(id: String) {
//        val intent = Intent(this, PlayListVideosActivity::class.java)
//        intent.putExtra("id", id)
//        startActivity(intent)
        Intent(this, PlayListVideosActivity::class.java).apply {
            putExtra("id", id)
            startActivity(this)
        }
    }

}
