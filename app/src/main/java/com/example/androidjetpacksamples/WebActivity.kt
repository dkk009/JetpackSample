package com.example.androidjetpacksamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    val htmltext = "<ol>" +
            "<li>Coffee</li>" +
            " <li>Tea </li>" +
            "<li>Milk </li>" + "</ol>" +
            "<ol>" +
            " <li>Tea </li>" +
            "<li>Milk </li>" + "</ol>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        txtInfo.setHtmlText(htmltext)
    }
}