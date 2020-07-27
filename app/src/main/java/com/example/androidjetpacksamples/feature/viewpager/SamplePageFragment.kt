package com.example.androidjetpacksamples.feature.viewpager

import android.os.Bundle
import com.example.androidjetpacksamples.R
import com.example.androidjetpacksamples.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_sample_page.*

class SamplePageFragment : BaseFragment(R.layout.fragment_sample_page) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            val pageNumber = it.getInt("PageNumber")
            txtPageNumber.text = pageNumber.toString()
        }
    }
}