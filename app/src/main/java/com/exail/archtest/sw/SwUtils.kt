package com.exail.archtest.sw

import com.google.gson.JsonArray
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by eduardsdenisjonoks  on 2019-05-31.
 */

/**
 * Get list of integers found in string
 * @param string - string value
 */
fun getIntsFromString(string: String): List<Int> {
    return string.replace("[^0-9]+".toRegex(), " ")
        .trim()
        .split(" ")
        .filter { value -> !value.isBlank() }
        .map { value -> value.toInt() }
}

/**
 * Get ID as int from URL
 * @param url - string value
 */
fun getIdFromUrl(url: String?): Int {
    if (url.isNullOrBlank()) {
        return -1
    }
    val integers = getIntsFromString(url)
    return if (integers.isEmpty()) -1 else integers.last()
}

/**
 * Convert list of URLs into list of IDs
 * Additionally will filter out all invalid IDs represented as '-1'
 * @param urls - nullable list of strings
 */
fun convertToListOfIds(urls: List<String>?): List<Int> {
    if (urls.isNullOrEmpty()) {
        return emptyList()
    }
    return urls.map { url -> getIdFromUrl(url) }.filter { id -> id != -1 }
}

/**
 * Convert json array of URLs into list of IDs
 * Additionally will filter out all invalid IDs represented as '-1'
 * @param array - nullable json array
 */
fun convertJsonArrayToIds(array: JsonArray?): List<Int> {
    if (array == null || array.size() == 0) {
        return emptyList()
    }
    return array.map { jsonElement -> getIdFromUrl(jsonElement.asString) }.filter { id -> id != -1 }
}

/**
 * Convert release date string to date
 * @param string - nullable string
 */
fun releaseDateStringToDate(string: String?): Date? {
    if (string.isNullOrBlank()) {
        return null
    }
    return SimpleDateFormat("yyyy-MM-d", Locale.getDefault()).parse(string)
}

/**
 * Convert release date to date string
 * @param date - nullable date
 */
fun releaseDateToDateString(date: Date?): String? {
    if (date == null) {
        return null
    }
    return SimpleDateFormat("yyyy-MM-d", Locale.getDefault()).format(date)
}