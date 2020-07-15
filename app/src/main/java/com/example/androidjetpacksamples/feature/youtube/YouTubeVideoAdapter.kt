package com.example.androidjetpacksamples.feature.youtube

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.androidjetpacksamples.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import kotlinx.android.synthetic.main.layout_youtube_viewholder.view.*

class YouTubeVideoHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val TAG = "YouTubeVideoHolder"
    private var localPlayer: YouTubePlayer? = null
    private var videoId = ""
    private var isAttached = false

    init {
        itemView.youtubeVideoView.initialize(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    localPlayer = youTubePlayer
                    bindYouTubePlayer()
                    Log.d(TAG, "youtubeplayer ready")
                }

                override fun onApiChange(youTubePlayer: YouTubePlayer) {
                    super.onApiChange(youTubePlayer)
                    Log.d(TAG, "youtubeplayer onApiChange")
                }

                override fun onStateChange(
                    youTubePlayer: YouTubePlayer,
                    state: PlayerConstants.PlayerState
                ) {
                    super.onStateChange(youTubePlayer, state)
                    Log.d(TAG, "youtubeplayer onStateChange")
                }
            },
            true,
            getYouTubePlayerOption()
        )
        Log.d(TAG, "youtubeplayer initialize")
    }

    fun bindData(videoId: String, onClick: OnClick<String>) {
        this.videoId = getVideoIdentifier(videoId) ?: ""
        if (localPlayer != null) {
            bindYouTubePlayer()
        }
        itemView.txtId.text = this.videoId
    }

    private fun getVideoIdentifier(finalUrl: String?): String? {
        val uri = Uri.parse(finalUrl)
        return uri.getQueryParameter("v")?: null
    }

    fun detachPlayer() {
        localPlayer?.pause()
        isAttached = false
    }

    fun attachPlayer() {
        isAttached = true
        bindYouTubePlayer()
    }

    private fun bindYouTubePlayer() {
        if (isAttached) {
            localPlayer?.cueVideo(videoId, 0f)
        }
    }

    fun getYouTubePlayerOption(): IFramePlayerOptions? {
        return IFramePlayerOptions.Builder().ccLoadPolicy(0).controls(0).ccLoadPolicy(3).build()
    }
}

open class YouTubeVideoAdapter(
    private val itemList: MutableList<String>,
    private val onClick: OnClick<String>, private val lifecycle: Lifecycle
) :
    RecyclerView.Adapter<YouTubeVideoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeVideoHolder {
        val holder = YouTubeVideoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_youtube_viewholder, parent, false)
        )
        lifecycle.addObserver(holder.itemView.youtubeVideoView)
        return holder
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: YouTubeVideoHolder, position: Int) {
        holder.bindData(itemList[position], onClick)
    }

    override fun onViewAttachedToWindow(holder: YouTubeVideoHolder) {
        super.onViewAttachedToWindow(holder)
        holder.attachPlayer()

    }

    override fun onViewDetachedFromWindow(holder: YouTubeVideoHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.detachPlayer()
    }

}

interface OnClick<T> {
    fun onClick(data: T, position: Int, tag: String)
}