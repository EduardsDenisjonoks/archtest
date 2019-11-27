package com.exail.archtest.koin

import com.exail.archtest.BuildConfig
import com.exail.archtest.cats.repository.CatApi
import com.exail.archtest.cats.repository.CatRepository
import com.exail.archtest.cats.repository.CatRepositoryImpl
import com.exail.archtest.chuck.norris.repository.ChuckNorrisApi
import com.exail.archtest.chuck.norris.repository.ChuckNorrisRepository
import com.exail.archtest.chuck.norris.repository.ChuckNorrisRepositoryImpl
import com.exail.archtest.sw.models.*
import com.exail.archtest.sw.repository.StarWarsApi
import com.exail.archtest.sw.repository.StarWarsRepository
import com.exail.archtest.sw.repository.StarWarsRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit


const val CAT_API_BASE_URL = "https://api.thecatapi.com/v1/"
const val CHUCK_NORRIS_API_BASE_URL = "https://api.icndb.com/"
const val SW_API_BASE_URL = "https://swapi.co/api/"

val networkModule = module {

    single { createHttpClient() }
    single { createWebService<CatApi>(get(), createGson(), CAT_API_BASE_URL) }
    single { createWebService<ChuckNorrisApi>(get(), createGson(), CHUCK_NORRIS_API_BASE_URL) }
    single { createWebService<StarWarsApi>(get(), createSwGson(), SW_API_BASE_URL) }

    factory<CatRepository> { CatRepositoryImpl(catApi = get()) }
    factory<ChuckNorrisRepository> { ChuckNorrisRepositoryImpl(chuckNorrisApi = get()) }
    factory<StarWarsRepository> { StarWarsRepositoryImpl(starWarsApi = get()) }

}

fun createHttpClient() =
    OkHttpClient.Builder().apply {
        this.readTimeout(300, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            this.addInterceptor(getHttpLoggingInterceptor())
        }
        this.addInterceptor {
            val original = it.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.header("Content-Type", "application/json")
            val request = requestBuilder.method(original.method, original.body).build()
            return@addInterceptor it.proceed(request)
        }
    }.build()

private fun getHttpLoggingInterceptor() =
    HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.tag("NETWORK").d(message)
        }
    }).apply { level = HttpLoggingInterceptor.Level.BODY }

private fun createGson() = GsonBuilder().setLenient().create()

private fun createSwGson() = GsonBuilder()
    .setLenient()
    .registerTypeAdapter(Film::class.java, getFilmDeserializer())
    .registerTypeAdapter(People::class.java, getPeopleDeserializer())
    .registerTypeAdapter(Planet::class.java, getPlanetDeserializer())
    .registerTypeAdapter(Specie::class.java, getSpecietDeserializer())
    .registerTypeAdapter(Starship::class.java, getStarshipDeserializer())
    .registerTypeAdapter(Vehicle::class.java, getVehicleDeserializer())
    .create()

private inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    gson: Gson,
    baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}
