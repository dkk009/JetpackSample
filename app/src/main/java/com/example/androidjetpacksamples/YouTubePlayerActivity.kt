package com.example.androidjetpacksamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjetpacksamples.feature.youtube.YoutubeVideoListFragment

class YouTubePlayerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager.beginTransaction().add(
            R.id.container,
            YoutubeVideoListFragment(),
            YoutubeVideoListFragment::class.java.simpleName
        ).commitAllowingStateLoss()
    }
}