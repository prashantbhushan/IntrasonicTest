package com.prashant.intrasonictest.utility

class MedianCalculator : Calculator {

    /**
     * Calculates median of given numbers
     * Median is middle element of array if size of array is odd
     * Else it is average of middle two elements
     */
    override fun calculate(numArray: Array<Long>): Double {
        val median = if (numArray.size % 2 != 0) {
            val midIndex = (numArray.size - 1) / 2
            numArray.get(midIndex).toDouble()
        } else {
            val midIndex = numArray.size / 2
            (numArray.get(midIndex) + numArray.get(midIndex - 1)).toDouble() / 2
        }
        return median
    }
}