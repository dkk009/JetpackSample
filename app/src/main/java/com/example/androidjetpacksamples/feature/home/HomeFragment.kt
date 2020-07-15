package com.example.androidjetpacksamples.feature.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import com.example.androidjetpacksamples.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
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
    }


    override fun onDestroyView() {
        homeFragmentBinding = null
        super.onDestroyView()
    }
}