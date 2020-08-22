package com.example.androidjetpacksamples.feature.fragmenttest

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidjetpacksamples.R
import kotlinx.android.synthetic.main.test_fragment.*

class FragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtInfo.text = "Fragment Two"
        next?.setOnClickListener {
            if (activity is FragmentTestActivity) {
                (activity as FragmentTestActivity).addFragment(FragmentThree(), true)
            }
        }
        view?.setBackgroundColor(Color.BLUE)
    }
}