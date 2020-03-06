package com.prashant.intrasonictest.utility

class MeanCalculator : Calculator {

    /**
     * Calculates mean of array elements which is average of value of elements
     */
    override fun calculate(numArray: Array<Long>): Double {
        val sum = numArray.fold(0L) { a, b -> a + b }
        val mean = sum.toDouble() / numArray.size
        return mean
    }
}