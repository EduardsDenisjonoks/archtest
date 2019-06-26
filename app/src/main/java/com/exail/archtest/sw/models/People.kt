package com.exail.archtest.sw.models

import android.os.Parcelable
import com.exail.archtest.sw.convertJsonArrayToIds
import com.exail.archtest.sw.getIdFromUrl
import com.google.gson.JsonDeserializer
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
@Parcelize
data class People(
    @Expose
    @SerializedName("url")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String = "",
    @Expose
    @SerializedName("gender")
    val gender: String = "",
    @Expose
    @SerializedName("birth_year")
    val birthYear: String = "",
    @Expose
    @SerializedName("eye_color")
    val eyeColor: String = "",
    @Expose
    @SerializedName("hair_color")
    val hairColor: String = "",
    @Expose
    @SerializedName("skin_color")
    val skinColor: String = "",
    @Expose
    @SerializedName("height")
    val height: String = "",
    @Expose
    @SerializedName("mass")
    val mass: String = "",
    @Expose
    @SerializedName("homeworld")
    val homeWorld: Int = -1,
    @Expose
    @SerializedName("species")
    val species: List<Int> = emptyList(),
    @Expose
    @SerializedName("starships")
    val starShips: List<Int> = emptyList(),
    @Expose
    @SerializedName("vehicles")
    val vehicles: List<Int> = emptyList(),
    @Expose
    @SerializedName("films")
    val films: List<Int> = emptyList()
) : Parcelable


fun getPeopleDeserializer() =
    JsonDeserializer<People> { jsonElement, _, _ ->
        val jsonObject = jsonElement.asJsonObject
        People(
            getIdFromUrl(jsonObject.get("url").asString),
            jsonObject.get("name").asString,
            jsonObject.get("gender").asString,
            jsonObject.get("birth_year").asString,
            jsonObject.get("eye_color").asString,
            jsonObject.get("hair_color").asString,
            jsonObject.get("skin_color").asString,
            jsonObject.get("height").asString,
            jsonObject.get("mass").asString,
            getIdFromUrl(jsonObject.get("homeworld").asString),
            convertJsonArrayToIds(jsonObject.get("species").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("starships").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("vehicles").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("films").asJsonArray)
        )
    }