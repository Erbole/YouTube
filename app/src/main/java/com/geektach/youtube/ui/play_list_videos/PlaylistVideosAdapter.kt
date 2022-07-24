package com.geektach.youtube.ui.play_list_videos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektach.youtube.databinding.PlaylistVideosItemBinding
import com.geektach.youtube.extencions.load
import com.geektach.youtube.models.Items

class PlaylistVideosAdapter(private var videos: ArrayList<Items>) :
    RecyclerView.Adapter<PlaylistVideosAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            PlaylistVideosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(videos[position])
    }

    override fun getItemCount() = videos.size

    inner class VideoViewHolder(private val binding: PlaylistVideosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(items: Items) {
            binding.ivVideo.load(items.snippet.thumbnails.medium.url)
            binding.tvVideoTitle.text = items.snippet.title
            binding.tvVideoTit.text = items.contentDetails.videoPublishedAt
        }
    }
}