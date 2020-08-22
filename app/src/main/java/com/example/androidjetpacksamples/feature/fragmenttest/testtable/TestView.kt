package com.example.androidjetpacksamples.feature.fragmenttest.testtable

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TestView : AppCompatTextView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}