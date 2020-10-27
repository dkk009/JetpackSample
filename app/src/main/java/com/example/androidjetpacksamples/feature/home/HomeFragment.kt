package com.example.androidjetpacksamples.feature.home

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.Observer
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.app.ScreenNavigation
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.databinding.FragmentHomeBinding
import com.example.androidjetpacksamples.feature.home.model.Repo
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.fragment_home) {
    @Inject
    lateinit var homeViewModel: HomeViewModel
    private var homeFragmentBinding: FragmentHomeBinding? = null
    private lateinit var adapterRepoItem: AdapterRepoItem
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeFragmentBinding = FragmentHomeBinding.bind(view)
        homeFragmentBinding?.lifecycleOwner = viewLifecycleOwner
        homeFragmentBinding?.homeViewModel = homeViewModel
        homeViewModel.screenNavigation.observe(viewLifecycleOwner, getScreenNavigationObserver())
    }

    private fun getScreenNavigationObserver(): Observer<in ScreenNavigation> {
        return Observer {
            when (it?.screenId) {
                R.id.action_homeFragment_to_repoDetailsFragment -> moveToRepoDetailsFragment(it.data)
            }
        }
    }

    private fun moveToRepoDetailsFragment(data: Parcelable?) {
        HomeFragmentDirections.actionHomeFragmentToRepoDetailsFragment(data = data as Repo)
    }


    override fun onDestroyView() {
        homeFragmentBinding = null
        super.onDestroyView()
    }
}