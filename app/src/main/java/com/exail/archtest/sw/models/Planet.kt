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
data class Planet(
    @Expose
    @SerializedName("url")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String = "",
    @Expose
    @SerializedName("diameter")
    val diameter: String = "",
    @Expose
    @SerializedName("rotation_period")
    val rotationPeriod: String = "",
    @Expose
    @SerializedName("orbital_period")
    val orbitalPeriod: String = "",
    @Expose
    @SerializedName("gravity")
    val gravity: String = "",
    @Expose
    @SerializedName("population")
    val population: String = "",
    @Expose
    @SerializedName("climate")
    val climate: String = "",
    @Expose
    @SerializedName("terrain")
    val terrain: String = "",
    @Expose
    @SerializedName("surface_water")
    val surfaceWater: String = "",
    @Expose
    @SerializedName("residents")
    val residents: List<Int> = emptyList(),
    @Expose
    @SerializedName("films")
    val films: List<Int> = emptyList()
) : Parcelable

fun getPlanetDeserializer() =
    JsonDeserializer<Planet> { jsonElement, _, _ ->
        val jsonObject = jsonElement.asJsonObject
        Planet(
            getIdFromUrl(jsonObject.get("url").asString),
            jsonObject.get("name").asString,
            jsonObject.get("diameter").asString,
            jsonObject.get("rotation_period").asString,
            jsonObject.get("orbital_period").asString,
            jsonObject.get("gravity").asString,
            jsonObject.get("population").asString,
            jsonObject.get("climate").asString,
            jsonObject.get("terrain").asString,
            jsonObject.get("surface_water").asString,
            convertJsonArrayToIds(jsonObject.get("residents").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("films").asJsonArray)
        )
    }