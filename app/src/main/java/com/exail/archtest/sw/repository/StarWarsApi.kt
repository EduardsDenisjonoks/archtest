package com.exail.archtest.sw.repository

import com.exail.archtest.core.network.PagingResponse
import com.exail.archtest.sw.models.*
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
interface StarWarsApi {

    @GET("films/{id}")
    fun getFilmById(@Path("id") filmId: Int): Deferred<Film>

    @GET("films/")
    fun getFilms(@Query("search") searchQuery: String?): Deferred<PagingResponse<Film>>


    @GET("people/{id}")
    fun getPeopleById(@Path("id") peopleId: Int): Deferred<People>

    @GET("people/")
    fun getPeoples(@Query("page") page: Int, @Query("search") searchQuery: String?): Deferred<PagingResponse<People>>


    @GET("planets/{id}")
    fun getPlanetById(@Path("id") peopleId: Int): Deferred<Planet>

    @GET("planets/")
    fun getPlanets(@Query("search") searchQuery: String?): Deferred<PagingResponse<Planet>>


    @GET("species/{id}")
    fun getSpecieById(@Path("id") peopleId: Int): Deferred<Specie>

    @GET("species/")
    fun getSpecies(@Query("search") searchQuery: String?): Deferred<PagingResponse<Specie>>


    @GET("starships/{id}")
    fun getStarShipById(@Path("id") peopleId: Int): Deferred<Starship>

    @GET("starships/")
    fun getStarShips(@Query("search") searchQuery: String?): Deferred<PagingResponse<Starship>>


    @GET("vehicles/{id}")
    fun getVehicleById(@Path("id") peopleId: Int): Deferred<Vehicle>

    @GET("vehicles/")
    fun getVehicles(@Query("search") searchQuery: String?): Deferred<PagingResponse<Vehicle>>
}