package com.exail.archtest.sw.models

import android.os.Parcelable
import com.exail.archtest.sw.convertJsonArrayToIds
import com.exail.archtest.sw.getIdFromUrl
import com.exail.archtest.sw.models.def.FilmEpisode
import com.exail.archtest.sw.releaseDateStringToDate
import com.google.gson.JsonDeserializer
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by eduardsdenisjonoks  on 2019-06-04.
 */
@Parcelize
data class Film(
    @Expose
    @SerializedName("url")
    val id: Int,
    @Expose
    @SerializedName("release_date")
    val releaseDate: Date?,
    @Expose
    @SerializedName("title")
    val title: String = "",
    @Expose
    @SerializedName("director")
    val director: String = "",
    @Expose
    @SerializedName("producer")
    val producer: String = "",
    @Expose
    @SerializedName("opening_crawl")
    val openingCrawl: String = "",
    @Expose
    @SerializedName("episode_id")
    @FilmEpisode val episodeId: Int = -1,
    @Expose
    @SerializedName("characters")
    val characters: List<Int> = emptyList(),
    @Expose
    @SerializedName("starships")
    val starShips: List<Int> = emptyList(),
    @Expose
    @SerializedName("vehicles")
    val vehicles: List<Int> = emptyList(),
    @Expose
    @SerializedName("species")
    val species: List<Int> = emptyList(),
    @Expose
    @SerializedName("planets")
    val planets: List<Int> = emptyList()
) : Parcelable

fun getFilmDeserializer() =
    JsonDeserializer<Film> { jsonElement, _, _ ->
        val jsonObject = jsonElement.asJsonObject
        Film(
            getIdFromUrl(jsonObject.get("url").asString),
            releaseDateStringToDate(jsonObject.get("release_date").asString),
            jsonObject.get("title").asString,
            jsonObject.get("director").asString,
            jsonObject.get("producer").asString,
            jsonObject.get("opening_crawl").asString,
            jsonObject.get("episode_id").asInt,
            convertJsonArrayToIds(jsonObject.get("characters").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("starships").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("vehicles").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("species").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("planets").asJsonArray)
        )
    }