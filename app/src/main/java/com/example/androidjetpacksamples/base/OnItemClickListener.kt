package com.example.androidjetpacksamples.base

import android.view.View

interface OnItemClickListener<Any> {
    fun onItemClick(dataModel: kotlin.Any, pos: Int, tag: String)
}