package com.prashant.intrasonictest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prashant.intrasonictest.utility.MeanCalculator
import com.prashant.intrasonictest.utility.MedianCalculator
import com.prashant.intrasonictest.utility.roundToNDecimalPlace

class MainViewModel(
    val meanCalculator: MeanCalculator,
    val medianCalculator: MedianCalculator
) : ViewModel() {

    private var _mean = MutableLiveData<Double>()
    val mean: LiveData<Double> = _mean

    private var _median = MutableLiveData<Double>()
    val median: LiveData<Double> = _median

    fun calculate(str: String) {
        val numArray = getNumberArrayFromInput(str)
        calculateMean(numArray)
        calculateMedian(numArray)
    }

    private fun calculateMean(numArray: Array<Long>) {
        _mean.value = meanCalculator.calculate(numArray).roundToNDecimalPlace(1)
    }

    private fun calculateMedian(numArray: Array<Long>) {
        _median.value = medianCalculator.calculate(numArray).roundToNDecimalPlace(1)
    }

    private fun getNumberArrayFromInput(str: String): Array<Long> =
        str.split(",").filter { it.isNotEmpty() }.map { it.trim().toLong() }.toTypedArray()

    fun clearInput() {
        _median.value = 0.0
        _mean.value = 0.0
    }
}