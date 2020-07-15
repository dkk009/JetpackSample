package com.example.androidjetpacksamples.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment {

    constructor() : super()
    constructor(@LayoutRes layoutId: Int) : super(layoutId)

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}