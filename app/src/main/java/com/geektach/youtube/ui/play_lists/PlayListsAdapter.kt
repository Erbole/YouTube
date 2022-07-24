package com.geektach.youtube.ui.play_lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektach.youtube.R
import com.geektach.youtube.databinding.PlaylistsItemsBinding
import com.geektach.youtube.extencions.loadImage
import com.geektach.youtube.models.Items

class PlayListsAdapter(private val playlists: ArrayList<Items>) :
    RecyclerView.Adapter<PlayListsAdapter.PlayListViewHolder>() {

    fun setListener(listener: ItemClickListener) {
        onItemClickListener = listener
    }

    private lateinit var onItemClickListener: ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListViewHolder {
        return PlayListViewHolder(
            PlaylistsItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.onBind(playlists[position])
    }

    override fun getItemCount() = playlists.size

    inner class PlayListViewHolder(private val binding: PlaylistsItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.ivPlaylist.loadImage(items.snippet.thumbnails.medium.url)
            binding.tvPlaylistTitle.text = items.snippet.title
            binding.tvVideoCounter.text = itemView.context.getString(
                R.string.video_series, items.contentDetails.itemCount
            )
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(
                    items.id,
                    items.snippet.title,
                    items.snippet.description
                )
            }
        }
    }
}

interface ItemClickListener {
    fun onItemClick(id: String, title: String, description: String)
}
