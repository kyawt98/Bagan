package com.kyawt.baganmap.utils

import android.content.Context
import com.kyawt.baganmap.constant.PrefKey

class SharePreferenceHelper (context: Context){
    private val pref = context.getSharedPreferences(PrefKey.BAGAN_MAP_PREF,Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun getToken(): String {
        return pref.getString(PrefKey.TOKEN_KEY,"")!!
    }
//
//    fun setLocale(locale: String){
//        editor.putString(PrefKey.LOCALE_KEY,locale).apply()
//    }
//
//    fun currentLocale(): String = pref.getString(PrefKey.LOCALE_KEY,"mm")!!

}