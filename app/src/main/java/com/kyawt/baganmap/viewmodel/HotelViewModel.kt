package com.kyawt.baganmap.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

var loading: MutableLiveData<Boolean> = MutableLiveData()
var error: MutableLiveData<Boolean> = MutableLiveData()
fun getLoading(): LiveData<Boolean> = loading
fun getError() : LiveData<Boolean> = error

//var hotelResult = MutableLiveData<Hotel>()

fun loadData(){
    loading.value = true

}