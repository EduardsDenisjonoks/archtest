package com.exail.archtest.sw.repository

import com.exail.archtest.core.network.ApiResult
import com.exail.archtest.core.network.PagingResponse
import com.exail.archtest.sw.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by eduardsdenisjonoks  on 2019-05-22.
 */
interface StarWarsRepository {
    //films
    suspend fun getFilms(id: Int): ApiResult<Film>

    suspend fun getFilms(page: Int, searchQuery: String?): ApiResult<PagingResponse<Film>>

    //people
    suspend fun getPeople(id: Int): ApiResult<People>

    suspend fun getPeoples(page: Int, searchQuery: String?): ApiResult<PagingResponse<People>>

    //planets
    suspend fun getPlanets(id: Int): ApiResult<Planet>

    suspend fun getPlanets(page: Int, searchQuery: String?): ApiResult<PagingResponse<Planet>>

    //species
    suspend fun getSpecies(id: Int): ApiResult<Specie>

    suspend fun getSpecies(page: Int, searchQuery: String?): ApiResult<PagingResponse<Specie>>

    //star ships
    suspend fun getStarShips(id: Int): ApiResult<Starship>

    suspend fun getStarShips(page: Int, searchQuery: String?): ApiResult<PagingResponse<Starship>>

    //vehicles
    suspend fun getVehicles(id: Int): ApiResult<Vehicle>

    suspend fun getVehicles(page: Int, searchQuery: String?): ApiResult<PagingResponse<Vehicle>>
}

class StarWarsRepositoryImpl(private val starWarsApi: StarWarsApi) : StarWarsRepository {
    //region FILMS
    override suspend fun getFilms(id: Int): ApiResult<Film> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getFilmById(id)
                when(val film = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(film)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override suspend fun getFilms(page: Int, searchQuery: String?): ApiResult<PagingResponse<Film>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getFilms(page, searchQuery)
                when(val pagingResponse = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(pagingResponse)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }
    //endregion

    //region PEOPLES
    override suspend fun getPeople(id: Int): ApiResult<People> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPeopleById(id)
                when(val person = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(person)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override suspend fun getPeoples(
        page: Int,
        searchQuery: String?
    ): ApiResult<PagingResponse<People>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPeoples(page, searchQuery)
                when(val pagingResponse = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(pagingResponse)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }
    //endregion

    //region PLANETS
    override suspend fun getPlanets(id: Int): ApiResult<Planet> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPlanetById(id)
                when(val planet = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(planet)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override suspend fun getPlanets(page: Int, searchQuery: String?): ApiResult<PagingResponse<Planet>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPlanets(page, searchQuery)
                when(val pagingResponse = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(pagingResponse)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }
    //endregion

    //region SPECIES
    override suspend fun getSpecies(id: Int): ApiResult<Specie> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getSpecieById(id)
                when(val specie = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(specie)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override suspend fun getSpecies(page: Int, searchQuery: String?): ApiResult<PagingResponse<Specie>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getSpecies(page, searchQuery)
                when(val pagingResponse = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(pagingResponse)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }
    //endregion

    //region STAR SHIPS
    override suspend fun getStarShips(id: Int): ApiResult<Starship> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getStarShipById(id)
                when(val starship = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(starship)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override suspend fun getStarShips(page: Int, searchQuery: String?): ApiResult<PagingResponse<Starship>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getStarShips(page, searchQuery)
                when(val pagingResponse = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(pagingResponse)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }
    //endregion

    //region VEHICLES
    override suspend fun getVehicles(id: Int): ApiResult<Vehicle> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getVehicleById(id)
                when(val vehicle = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(vehicle)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }

    override suspend fun getVehicles(page: Int, searchQuery: String?): ApiResult<PagingResponse<Vehicle>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getVehicles(page, searchQuery)
                when(val pagingResponse = result.body()){
                    null -> ApiResult.empty()
                    else -> ApiResult.success(pagingResponse)
                }
            } catch (ex: Exception) {
                ApiResult.error(ex)
            }
        }
    }
    //endregion
}