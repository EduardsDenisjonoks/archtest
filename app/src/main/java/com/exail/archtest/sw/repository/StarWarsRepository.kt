package com.exail.archtest.sw.repository

import com.exail.archtest.core.network.ApiResult
import com.exail.archtest.core.network.ErrorEntity
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

    suspend fun getFilms(searchQuery: String?): ApiResult<PagingResponse<Film>>

    //people
    suspend fun getPeople(id: Int): ApiResult<People>

    suspend fun getPeoples(page: Int, searchQuery: String?): ApiResult<PagingResponse<People>>

    //planets
    suspend fun getPlanets(id: Int): ApiResult<Planet>

    suspend fun getPlanets(searchQuery: String?): ApiResult<PagingResponse<Planet>>

    //species
    suspend fun getSpecies(id: Int): ApiResult<Specie>

    suspend fun getSpecies(searchQuery: String?): ApiResult<PagingResponse<Specie>>

    //star ships
    suspend fun getStarShips(id: Int): ApiResult<Starship>

    suspend fun getStarShips(searchQuery: String?): ApiResult<PagingResponse<Starship>>

    //vehicles
    suspend fun getVehicles(id: Int): ApiResult<Vehicle>

    suspend fun getVehicles(searchQuery: String?): ApiResult<PagingResponse<Vehicle>>
}

class StarWarsRepositoryImpl(private val starWarsApi: StarWarsApi) : StarWarsRepository {
    //region FILMS
    override suspend fun getFilms(id: Int): ApiResult<Film> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getFilmById(id).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }

    override suspend fun getFilms(searchQuery: String?): ApiResult<PagingResponse<Film>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getFilms(searchQuery).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }
    //endregion

    //region PEOPLES
    override suspend fun getPeople(id: Int): ApiResult<People> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPeopleById(id).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }

    override suspend fun getPeoples(
        page: Int,
        searchQuery: String?
    ): ApiResult<PagingResponse<People>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPeoples(page, searchQuery).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }
    //endregion

    //region PLANETS
    override suspend fun getPlanets(id: Int): ApiResult<Planet> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPlanetById(id).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }

    override suspend fun getPlanets(searchQuery: String?): ApiResult<PagingResponse<Planet>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getPlanets(searchQuery).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }
    //endregion

    //region SPECIES
    override suspend fun getSpecies(id: Int): ApiResult<Specie> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getSpecieById(id).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }

    override suspend fun getSpecies(searchQuery: String?): ApiResult<PagingResponse<Specie>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getSpecies(searchQuery).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }
    //endregion

    //region STAR SHIPS
    override suspend fun getStarShips(id: Int): ApiResult<Starship> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getStarShipById(id).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }

    override suspend fun getStarShips(searchQuery: String?): ApiResult<PagingResponse<Starship>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getStarShips(searchQuery).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }
    //endregion

    //region VEHICLES
    override suspend fun getVehicles(id: Int): ApiResult<Vehicle> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getVehicleById(id).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }

    override suspend fun getVehicles(searchQuery: String?): ApiResult<PagingResponse<Vehicle>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = starWarsApi.getVehicles(searchQuery).await()
                ApiResult.Success(result)
            } catch (ex: Exception) {
                ApiResult.Error(ErrorEntity.Unknown(ex))
            }
        }
    }
    //endregion
}