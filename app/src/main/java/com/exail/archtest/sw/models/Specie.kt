package com.exail.archtest.sw.models

import android.os.Parcelable
import com.exail.archtest.sw.convertJsonArrayToIds
import com.exail.archtest.sw.getIdFromUrl
import com.google.gson.JsonDeserializer
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by eduardsdenisjonoks  on 2019-06-04.
 */
@Parcelize
data class Specie(
    @Expose
    @SerializedName("url")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String = "",
    @Expose
    @SerializedName("classification")
    val classification: String = "",
    @Expose
    @SerializedName("designation")
    val designation: String = "",
    @Expose
    @SerializedName("average_height")
    val averageHeight: String = "",
    @Expose
    @SerializedName("average_lifespan")
    val averageLifespan: String = "",
    @Expose
    @SerializedName("eye_colors")
    val eyeColors: String = "",
    @Expose
    @SerializedName("hair_colors")
    val hairColors: String = "",
    @Expose
    @SerializedName("skin_colors")
    val skinColors: String = "",
    @Expose
    @SerializedName("language")
    val language: String = "",
    @Expose
    @SerializedName("homeworld")
    val homeWorld: Int = -1,
    @Expose
    @SerializedName("people")
    val people: List<Int> = emptyList(),
    @Expose
    @SerializedName("films")
    val films: List<Int> = emptyList()
) : Parcelable

fun getSpecietDeserializer() =
    JsonDeserializer<Specie> { jsonElement, _, _ ->
        val jsonObject = jsonElement.asJsonObject
        Specie(
            getIdFromUrl(jsonObject.get("url").asString),
            jsonObject.get("name").asString,
            jsonObject.get("classification").asString,
            jsonObject.get("designation").asString,
            jsonObject.get("average_height").asString,
            jsonObject.get("average_lifespan").asString,
            jsonObject.get("eye_colors").asString,
            jsonObject.get("hair_colors").asString,
            jsonObject.get("skin_colors").asString,
            jsonObject.get("language").asString,
            jsonObject.get("surface_water").asInt,
            convertJsonArrayToIds(jsonObject.get("people").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("films").asJsonArray)
        )
    }