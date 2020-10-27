package com.example.androidjetpacksamples.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.example.androidjetpacksamples.base.BaseFragment

fun BaseFragment.hideKeyBoard() {
    view?.let {
        val imeManager =
            context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imeManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}