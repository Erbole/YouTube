package com.geektach.youtube.ui.play_lists

import android.content.Intent
import com.geektach.youtube.core.BaseActivity
import com.geektach.youtube.databinding.ActivityPlaylistsBinding
import com.geektach.youtube.models.Items
import com.geektach.youtube.ui.play_list_videos.PlayListVideosActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListActivity : BaseActivity<ActivityPlaylistsBinding>(), ItemClickListener {

    private val viewModel: PlayListsViewModel by viewModel()
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

    override fun onItemClick(id: String, title: String, description: String) {
//        val intent = Intent(this, PlayListVideosActivity::class.java)
//        intent.putExtra("id", id)
//        startActivity(intent)
        Intent(this, PlayListVideosActivity::class.java).apply {
            putExtra("id", id)
            putExtra("description", description)
            putExtra("title", title)
            startActivity(this)
        }
    }

}
