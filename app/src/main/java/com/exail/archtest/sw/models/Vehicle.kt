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
data class Vehicle(
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
    @SerializedName("vehicle_class")
    val vehicleClass: String = "",
    @Expose
    @SerializedName("manufacturer")
    val manufacturer: String = "",
    @Expose
    @SerializedName("length")
    val length: String = "",
    @Expose
    @SerializedName("cost_in_credits")
    val costInCredits: String = "",
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

fun getVehicleDeserializer() =
    JsonDeserializer<Vehicle> { jsonElement, _, _ ->
        val jsonObject = jsonElement.asJsonObject
        Vehicle(
            getIdFromUrl(jsonObject.get("url").asString),
            jsonObject.get("name").asString,
            jsonObject.get("model").asString,
            jsonObject.get("vehicle_class").asString,
            jsonObject.get("manufacturer").asString,
            jsonObject.get("length").asString,
            jsonObject.get("cost_in_credits").asString,
            jsonObject.get("crew").asString,
            jsonObject.get("passengers").asString,
            jsonObject.get("max_atmosphering_speed").asString,
            jsonObject.get("cargo_capacity").asString,
            jsonObject.get("consumables").asString,
            convertJsonArrayToIds(jsonObject.get("films").asJsonArray),
            convertJsonArrayToIds(jsonObject.get("pilots").asJsonArray)
        )
    }
