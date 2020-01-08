package com.aungmyolwin.splasher.utils

import com.google.gson.Gson

/**
 * a touch of amlwin on 2020-01-08.
 * made with <3
 */

class ParserUtils {

    val gson = Gson()

    fun stringtoObject() {

    }

    fun objectToString(sourceObject: Any): String {
        return gson.toJson(sourceObject)
    }
}