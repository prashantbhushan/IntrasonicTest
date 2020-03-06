package com.prashant.intrasonictest

import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.prashant.intrasonictest.utility.MeanCalculator
import com.prashant.intrasonictest.utility.MedianCalculator


class MainViewModelFactory(
    val meanCalculator: MeanCalculator,
    val medianCalculator: MedianCalculator
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(meanCalculator, medianCalculator) as T
    }
}