package com.aungmyolwin.splasher.utils

import com.google.gson.Gson

/**
 * a touch of amlwin on 2020-01-08.
 * made with <3
 */

class ParserUtils {

    val gson = Gson()

    fun <T> stringToObject(rawString: String, type: Class<T>): T {
        return gson.fromJson(rawString, type)
    }

    fun objectToString(sourceObject: Any): String {
        return gson.toJson(sourceObject)
    }
}