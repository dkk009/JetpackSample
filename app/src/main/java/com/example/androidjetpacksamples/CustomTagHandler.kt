package com.example.androidjetpacksamples

import android.text.Editable
import android.text.Html
import android.text.Spannable
import android.text.style.BulletSpan
import org.xml.sax.XMLReader
import timber.log.Timber
import java.util.*

class CustomTagHandler : Html.TagHandler {
    private val ORDERED_LIST = "orderedList"
    private val LIST_ITEM = "listitem"
    private var index = 1
    var lists = Stack<String>()
    fun overRideTags(htmltext: String): String {
        return htmltext.replace("<ol", "<$ORDERED_LIST").replace("</ol", "</$ORDERED_LIST")
            .replace("<li", "<$LIST_ITEM").replace("</li", "</$LIST_ITEM")

    }

    override fun handleTag(
        opening: Boolean,
        tag: String?,
        output: Editable?,
        xmlReader: XMLReader?
    ) {
        if (opening) {
            if (ORDERED_LIST == tag) {
                index = 1
            }
            if (LIST_ITEM == tag) {

                output?.append("\n $index  ")
                val spanStartIndex = output?.length?.minus(1)
                output?.setSpan(
                    BulletSpan(60),
                    output.length - 1,
                    output.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                index++
            }
        } else {
            if (ORDERED_LIST == tag) {
                index = 1
            }
            if (LIST_ITEM == tag) {
                output?.append("\n")
            }

        }

        Timber.d("Opening:" + opening + ",Tag:$tag, output:${output.toString()}")
    }

}