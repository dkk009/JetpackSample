package com.example.androidjetpacksamples.app

import android.content.Context
import android.content.SharedPreferences

const val PREF_NAME = "sharedPref"
class PreferenceManager (context: Context) {
    var preference: SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun writeString(key:String,value:String): Boolean{
        return preference.edit().putString(key,value).commit()
    }
}