package com.exail.archtest.sw

import org.junit.Test

import org.junit.Assert.*

class SwUtilsKtTest {

    @Test
    fun test_getIdFromUrl() {
        val urlOne = "https://swapi.co/api/films/1/"
        val urlTwo = "https://swapi.co/api/starships/12/"
        val urlThree = "https://swapi.co/api/vehicles/14/"

        val urlFour = "https://swapi.co/api/vehicles/14"
        val urlFive = "https://swapi.co/api/vehicles14/"
        val urlSix = "https://r221swapi.co/213api/vehicles14"

        val urlSeven = ""
        val urlEight = "https://swapi.co/api/vehicles"

        val test = "https://swapi.co/api/people/?page=2"

        val resultOne = getIdFromUrl(urlOne)
        val resultTwo = getIdFromUrl(urlTwo)
        val resultThree = getIdFromUrl(urlThree)

        val resultFour = getIdFromUrl(urlFour)
        val resultFive = getIdFromUrl(urlFive)
        val resultSix = getIdFromUrl(urlSix)

        val resultSeven = getIdFromUrl(urlSeven)
        val resultEight = getIdFromUrl(urlEight)

        val testResult = getIdFromUrl(test)

        assertEquals(1, resultOne)
        assertEquals(12, resultTwo)
        assertEquals(14, resultThree)
        assertEquals(14, resultFour)
        assertEquals(14, resultFive)
        assertEquals(14, resultSix)
        assertEquals(-1, resultSeven)
        assertEquals(-1, resultEight)

    }

    @Test
    fun test_convertToListOfIds() {
        val emptyList = emptyList<String>()
        val urls = listOf(
            "https://swapi.co/api/films/1/",
            "https://swapi.co/api/starships/12/",
            "https://swapi.co/api/vehicles/14/"
        )
        val invalidValues = listOf(
            "",
            "https://r221swapi.co/213api/vehicles14",
            "https://swapi.co/api/vehicles/"
        )

        val resultOne = convertToListOfIds(emptyList)
        val resultTwo = convertToListOfIds(urls)
        val resultThree = convertToListOfIds(invalidValues)

        assertEquals(listOf<Int>(), resultOne)
        assertEquals(listOf(1,12,14), resultTwo)
        assertEquals(listOf(14), resultThree)
    }
}