package com.aungmyolwin.splasher.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * a touch of AungMyoLwin on 8/2/18.
 *     made with <3
 */

data class Urls(@SerializedName("raw")
                @Expose
                val raw: String,
                @SerializedName("full")
                @Expose
                val full: String,
                @SerializedName("regular")
                @Expose
                val regular: String,
                @SerializedName("small")
                @Expose
                val small: String,
                @SerializedName("thumb")
                @Expose
                val thumb: String
)

/*
*
@SerializedName("raw")
@Expose
private String raw;
@SerializedName("full")
@Expose
private String full;
@SerializedName("regular")
@Expose
private String regular;
@SerializedName("small")
@Expose
private String small;
@SerializedName("thumb")
@Expose
private String thumb;*/