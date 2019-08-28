package com.aungmyolwin.splasher.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * a touch of AungMyoLwin on 7/31/18.
 *     made with <3
 */

data class Photo(
        @SerializedName("id")
        @Expose
        var id: String,
        @SerializedName("created_at")
        @Expose
        var created_at: String,
        @SerializedName("width")
        @Expose
        var with: Int,
        @SerializedName("height")
        @Expose
        var height: Int,
        @SerializedName("color")
        @Expose
        var color: String,
        @SerializedName("urls")
        @Expose
        var urls: Urls)


