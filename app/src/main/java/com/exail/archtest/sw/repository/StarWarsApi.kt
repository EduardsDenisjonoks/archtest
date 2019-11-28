package com.exail.archtest.sw.repository

import com.exail.archtest.core.network.PagingResponse
import com.exail.archtest.sw.models.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
interface StarWarsApi {

    @GET("films/{id}")
    suspend fun getFilmById(@Path("id") filmId: Int): Response<Film>

    @GET("films/")
    suspend fun getFilms(@Query("page") page: Int, @Query("search") searchQuery: String?): Response<PagingResponse<Film>>


    @GET("people/{id}")
    suspend fun getPeopleById(@Path("id") peopleId: Int): Response<People>

    @GET("people/")
    suspend fun getPeoples(@Query("page") page: Int, @Query("search") searchQuery: String?): Response<PagingResponse<People>>


    @GET("planets/{id}")
    suspend fun getPlanetById(@Path("id") peopleId: Int): Response<Planet>

    @GET("planets/")
    suspend fun getPlanets(@Query("page") page: Int, @Query("search") searchQuery: String?): Response<PagingResponse<Planet>>


    @GET("species/{id}")
    suspend fun getSpecieById(@Path("id") peopleId: Int): Response<Specie>

    @GET("species/")
    suspend fun getSpecies(@Query("page") page: Int, @Query("search") searchQuery: String?): Response<PagingResponse<Specie>>


    @GET("starships/{id}")
    suspend fun getStarShipById(@Path("id") peopleId: Int): Response<Starship>

    @GET("starships/")
    suspend fun getStarShips(@Query("page") page: Int, @Query("search") searchQuery: String?): Response<PagingResponse<Starship>>


    @GET("vehicles/{id}")
    suspend fun getVehicleById(@Path("id") peopleId: Int): Response<Vehicle>

    @GET("vehicles/")
    suspend fun getVehicles(@Query("page") page: Int, @Query("search") searchQuery: String?): Response<PagingResponse<Vehicle>>
}