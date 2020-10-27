package com.example.androidjetpacksamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.androidjetpacksamples.app.PreferenceManager
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.base.IntrNavGraph
import com.google.firebase.iid.FirebaseInstanceId
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IntrNavGraph {

    @Inject
    lateinit var preferenceManager: PreferenceManager
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("PreferenceManager:$preferenceManager")
    }

    override fun updateNavGraph(navGraphId: Int) {
        supportFragmentManager.findFragmentByTag("nav_fragment")?.let { navHost ->
            if (navHost is NavHostFragment) {
                val navInflater = navHost.navController.navInflater
                val graph = navInflater.inflate(navGraphId)
                navHost.navController.graph = graph
            }
        }
    }

    override fun updateDestination(fragment: BaseFragment) {

    }
}
