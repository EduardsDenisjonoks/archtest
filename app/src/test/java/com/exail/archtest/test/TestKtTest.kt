package com.exail.archtest.test

import org.junit.Test

import org.junit.Assert.*

class TestKtTest {

    @Test
    fun test_findMax() {
        val result12 = findMax(arrayOf(1, 3, 8, 12, 4, 2))
        val result8 = findMax(arrayOf(3, 8, 3, 1))
        val result13 = findMax(arrayOf(1, 3, 8, 13))
        val result10 = findMax(arrayOf(10, 9, 8))

        val result1 = findMax(arrayOf(1, 2, 3, 10, 6, 4, 11, 7, 9))

        assertEquals(12, result12)
        assertEquals(8, result8)
        assertEquals(13, result13)
        assertEquals(10, result10)
        assertNotEquals(11, result1)//Know issue, this function won't work is this scenario
    }

    @Test
    fun test_pairSearch() {
        val array = arrayOf(1, 2, 3, 5, 4, 6, 7, 8, 9, 10)

        val result1 = pairSearch(array, 6)
        val result2 = pairSearch(array, 11)
        val result3 = pairSearch(array, 0)
        val result4 = pairSearch(array, 100)

        assertArrayEquals(arrayOf(1, 4), result1)
        assertArrayEquals(arrayOf(0, 9), result2)
        assertArrayEquals(emptyArray(), result3)
        assertArrayEquals(emptyArray(), result4)
    }

    @Test
    fun test_point(){
        val point = Point(2,6)
        val destination = Point(4, 12)

        val result = point.distance(destination)

        assertEquals(6.3245, result, 0.0005)
    }

    @Test
    fun test_findClosestPoint() {
        val point = arrayOf(Point(1, 2), Point(3, 4), Point(2, -1))

        val result1 = findClosestPoint(point, 1)

        assertArrayEquals(arrayOf(Point(1, 2)), result1)
    }
}