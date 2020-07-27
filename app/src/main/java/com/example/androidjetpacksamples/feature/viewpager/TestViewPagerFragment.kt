package com.example.androidjetpacksamples.feature.viewpager

import android.os.Bundle
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_test_viewpager.*

class TestViewPagerFragment : BaseFragment(R.layout.fragment_test_viewpager) {

    private var counter = 2
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataList = mutableListOf<Int>()
        for (i in 0..1) {
            dataList.add(i)
        }
        val viewPagerAdapter =
            SampleViewPagerAdapter(
                fragmentManager = childFragmentManager,
                itemList = dataList,
                viewLifeCycle = lifecycle
            )
        viewPager.adapter = viewPagerAdapter
        button_add.setOnClickListener {
            dataList.add(counter)
            counter++
            viewPagerAdapter.notifyDataSetChanged()
            viewPager.currentItem = counter
        }
    }

}