package com.example.androidjetpacksamples.feature.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SampleViewPagerAdapter(
    fragmentManager: FragmentManager,
    viewLifeCycle: Lifecycle,
    private val itemList: List<Int>
) : FragmentStateAdapter(fragmentManager, viewLifeCycle) {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putInt("PageNumber", itemList[position])
        val fragment = SamplePageFragment()
        fragment.arguments = bundle
        return fragment
    }

}