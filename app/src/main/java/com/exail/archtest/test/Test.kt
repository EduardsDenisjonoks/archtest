package com.exail.archtest.test

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.math.sqrt

fun findMax(array: Array<Int>): Int {
    var start = 0
    var end: Int = array.size - 1

    if (end <= 0) return 0

    while (start < end) {
        var mid = start + (end - start) / 2
        when {
            array[mid] > array[mid + 1] -> end = mid
            else -> start = ++mid
        }
    }

    return array[start]
}

fun pairSearch(array: Array<Int>, target: Int): Array<Int> {
    val sortedArray = array.sortedArray()
    var start = 0
    var end = sortedArray.size - 1

    if (end <= 0 || target <= 0) return emptyArray()

    while (start < end) {
        val targetDifference = target - array[start]
        when {
            targetDifference == array[end] -> return arrayOf(start, end)
            targetDifference > array[end] -> start++
            else -> end--
        }
    }
    return emptyArray()
}

public data class Point(val x: Int, val y: Int) {
    fun distFromOrigin() = (x * x) + (y * y)
    fun distance(destination: Point) : Double {
        val xDifference = x - destination.x
        val yDifference = y - destination.y

        return sqrt(((xDifference * xDifference) + (yDifference * yDifference)).toDouble())
    }
}

@RequiresApi(Build.VERSION_CODES.N)
fun findClosestPoint(array: Array<Point>, target: Int): Array<Point> {
    val maxHeap = PriorityQueue<Point>(Comparator { p1, p2 -> p2.distFromOrigin() - p1.distFromOrigin()})
    for (i in 0 until target){
        maxHeap.add(array[i])
    }
    for (i in target until array.size ){
        if (array[i].distFromOrigin() < maxHeap.peek().distFromOrigin()){
            maxHeap.poll()
            maxHeap.add(array[i])
        }
    }
    return maxHeap.toTypedArray()
}
