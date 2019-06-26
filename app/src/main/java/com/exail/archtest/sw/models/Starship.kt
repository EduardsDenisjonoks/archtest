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
data class Starship(
    @Expose
    @SerializedName("url")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String = "",
    @Expose
    @SerializedName("model")
    val model: String = "",
    @Expose
    @SerializedName("starship_class")
    val starShipClass: String = "",
    @Expose
    @SerializedName("manufacturer")
    val manufacturer: String = "",
    @Expose
    @SerializedName("cost_in_credits")
    val costInCredits: String = "",
    @Expose
    @SerializedName("length")
    val length: String = "",
    @Expose
    @SerializedName("crew")
    val crew: String = "",
    @Expose
    @SerializedName("passengers")
    val passengers: String = "",
    @Expose
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String = "",
    @Expose
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String = "",
    @Expose
    @SerializedName("MGLT")
    val mglt: String = "",
    @Expose
    @SerializedName("cargo_capacity")
    val cargoCapacity: String = "",
    @Expose
    @SerializedName("consumables")
    val consumables: String = "",
    @Expose
    @SerializedName("films")
    val films: List<Int> = emptyList(),
    @Expose
    @SerializedName("pilots")
    val pilots: List<Int> = emptyList()
) : Parcelable

fun getStarshipDeserializer() =
    JsonDeserializer<Starship> { jsonElement, _, _ ->
        val jsonObject = jsonElement.asJsonObject
        Starship(
            getIdFromUrl(jsonObject.get("url").asString),
            jsonObject.get("name").asString,
            jsonObject.get("model").asString,
            jsonObject.get("starship_class").asString,
            jsonObject.get("manufacturer").asString,
            jsonObject.get("cost_in_credits").asString,
            jsonObject.get("length").asString,
            jsonObject.get("crew").asString,
            jsonObject.get("passengers").asString,
            jsonObject.get("max_atmosphering_speed").asString,
            jsonObject.get("hyperdrive_rating").asString,
            jsonObject.get("MGLT").asString,
            jsonObject.get("cargo_capacity").asString,
            jsonObject.get("consumables").asString,
            convertJsonArrayToIds(jsonObject.get("films").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("pilots").asJsonArray)
        )
    }
