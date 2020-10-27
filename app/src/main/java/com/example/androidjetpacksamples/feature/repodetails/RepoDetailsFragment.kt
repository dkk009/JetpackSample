package com.example.androidjetpacksamples.feature.repodetails

import android.os.Bundle
import android.view.View
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.databinding.FragmentRepoDetailsBinding
import com.example.androidjetpacksamples.feature.home.model.Repo

class RepoDetailsFragment : BaseFragment(R.layout.fragment_repo_details) {
    private var repoDetailFragmentBinding: FragmentRepoDetailsBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        repoDetailFragmentBinding = FragmentRepoDetailsBinding.bind(view)
        repoDetailFragmentBinding?.lifecycleOwner = viewLifecycleOwner
        arguments?.getParcelable<Repo>("data")?.let {
            repoDetailFragmentBinding?.repoData = it
        }
    }
}