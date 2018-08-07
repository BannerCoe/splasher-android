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


/*
* @SerializedName("id")
@Expose
private String id;
@SerializedName("created_at")
@Expose
private String createdAt;
@SerializedName("updated_at")
@Expose
private String updatedAt;
@SerializedName("width")
@Expose
private Integer width;
@SerializedName("height")
@Expose
private Integer height;
@SerializedName("color")
@Expose
private String color;
@SerializedName("description")
@Expose
private Object description;
@SerializedName("urls")
@Expose
private Urls urls;
@SerializedName("links")
@Expose
private Links links;
@SerializedName("categories")
@Expose
private List<Object> categories = null;*/