package com.kyawt.baganmap.view.exts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun Context.bindView(layoutRes: Int, container : ViewGroup) : View {
    return LayoutInflater.from(this).inflate(layoutRes,container,false)
}