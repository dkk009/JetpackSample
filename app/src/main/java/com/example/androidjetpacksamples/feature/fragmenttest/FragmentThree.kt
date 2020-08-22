package com.example.androidjetpacksamples.feature.fragmenttest

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.androidjetpacksamples.R
import kotlinx.android.synthetic.main.test_fragment.*


class FragmentThree : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtInfo.text = "Fragment Three"
        next?.setOnClickListener {
            if (activity is FragmentTestActivity) {
                // (activity as FragmentTestActivity).addFragment(Fr(), true)
            }
        }
        view?.setBackgroundColor(Color.GREEN)
    }

    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
        var anim =
            super.onCreateAnimation(transit, enter, nextAnim)
        if (enter) {
            anim = AnimationUtils.loadAnimation(context, nextAnim)
        }
        anim?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                removeFragmentTwo()
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        return anim
    }

    private fun removeFragmentTwo() {
        (activity as FragmentTestActivity).removeSecondFragment()
    }
}