package com.kyawt.baganmap.Model

import com.google.gson.annotations.SerializedName

class article {
    @SerializedName("id")
    var iD: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("username")
    var username: String? = null

    fun setId(id: String?) {
        iD = id
    }

    fun getID(): Any {
        TODO("Not yet implemented")
    }

    fun getName(): Any {
        TODO("Not yet implemented")
    }

    fun getUsername(): Any {
        TODO("Not yet implemented")
    }

}

