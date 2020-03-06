package com.prashant.intrasonictest.utility

import org.junit.Before
import org.junit.Test

class MedianCalculatorTest {

    // Subject under test
    private lateinit var calculator: MedianCalculator

    @Before
    fun setUp() {
        calculator = MedianCalculator()
    }

    @Test
    fun calculate() {
        // given
        val inputArray = longArrayOf(23, 37, 42, 55, 60, 72, 83, 91).toTypedArray()

        // then validate median value
        assert(calculator.calculate(inputArray).roundToNDecimalPlace(1) == 57.5)
    }
}