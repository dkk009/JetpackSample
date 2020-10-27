package com.example.androidjetpacksamples.feature.repodetails

import android.os.Bundle
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.feature.home.model.Repo
import timber.log.Timber

class RepoDetailsFragment : BaseFragment(R.layout.fragment_repo_details) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val data = arguments?.getParcelable<Repo>("data")
        Timber.d("I am repo detail screen:$data")
    }
}