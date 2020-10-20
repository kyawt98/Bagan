package com.kyawt.baganmap.utils

import android.content.Context
import com.kyawt.baganmap.constant.PrefKey

class SharePreferenceHelper (context: Context){
    private val pref = context.getSharedPreferences(PrefKey.BAGAN_MAP_PREF,Context.MODE_PRIVATE)

    fun getToken(): String {
        return pref.getString(PrefKey.TOKEN_KEY,"")!!
    }

}