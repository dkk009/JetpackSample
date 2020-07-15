package com.example.androidjetpacksamples.feature.youtube

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidjetpacksamples.R
import kotlinx.android.synthetic.main.fragment_youtube_video_list.*

class YoutubeVideoListFragment : Fragment() {

    /**
     * "https://www.youtube.com/watch?v=d7UxPYxgBoA",
    "https://www.youtube.com/watch?v=CZ3wIuvmHeM",
    "https://www.youtube.com/watch?v=dC9vdQkU-xI"
     */
    private val sampleVideos = mutableListOf<String>(
        "https://www.youtube.com/watch?v=PVf-1MON6Pc",
        "https://www.youtube.com/watch?v=CZ3wIuvmHeM",
        "https://www.youtube.com/watch?v=dC9vdQkU-xI",
        "https://www.youtube.com/watch?v=d7UxPYxgBoA",
        "https://www.youtube.com/watch?v=I32hmY4diFY",
        "https://www.youtube.com/watch?v=6yG2myKcMQE",
        "https://www.youtube.com/watch?v=U7I2Yli9NZw"

    )
    private val youTubeVideoAdapter = YouTubeVideoAdapter(sampleVideos, object : OnClick<String> {
        override fun onClick(data: String, position: Int, tag: String) {

        }
    }, lifecycle)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_youtube_video_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvYouTube.layoutManager = LinearLayoutManager(context)
        rvYouTube.adapter = youTubeVideoAdapter

    }

}