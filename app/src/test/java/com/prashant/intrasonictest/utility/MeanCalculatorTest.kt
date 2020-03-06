package com.prashant.intrasonictest.utility

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MeanCalculatorTest {

    // Subject under test
    private lateinit var calculator: MeanCalculator

    @Before
    fun setUp() {
        calculator = MeanCalculator()
    }

    @Test
    fun calculate() {
        // given
        val inputArray = longArrayOf(23, 37, 42, 55, 60, 72, 83, 91).toTypedArray()

        // then validate median value
        assert(calculator.calculate(inputArray).roundToNDecimalPlace(1) == 57.9)
    }
}