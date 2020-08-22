package com.example.androidjetpacksamples.feature

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import com.example.androidjetpacksamples.CustomTagHandler
import timber.log.Timber

class HtmlTextView : AppCompatTextView {
    val tagHandler = CustomTagHandler()
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
    }

    fun setHtmlText(htmlContent: String) {
        Timber.d("Html text:${tagHandler.overRideTags(htmlContent)}")
        text = HtmlCompat.fromHtml(
            tagHandler.overRideTags(htmlContent),
            HtmlCompat.FROM_HTML_MODE_COMPACT,
            null,
            CustomTagHandler()
        )
    }

}