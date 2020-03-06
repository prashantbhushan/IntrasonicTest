package com.prashant.intrasonictest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prashant.intrasonictest.utility.MeanCalculator
import com.prashant.intrasonictest.utility.MedianCalculator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        setUpClickListener()
        setEditEndClickListener()
    }

    private fun setEditEndClickListener() {
        etInputLayout.setEndIconOnClickListener {
            etInput.setText("")
            viewModel.clearInput()
        }
    }

    private fun setUpClickListener() {
        btnCalculate.setOnClickListener { viewModel.calculate(etInput.text.toString()) }
    }

    private fun setUpViewModel() {
        viewModel =
            ViewModelProviders.of(this, MainViewModelFactory(MeanCalculator(), MedianCalculator()))
                .get(MainViewModel::class.java)

        // set observer for mean
        viewModel.mean.observe(this, Observer<Double> { mean ->
            // update mean value on UI
            tvMean.text = getString(R.string.mean, mean.toString())
        })

        // set observer for median
        viewModel.median.observe(this, Observer<Double> { median ->
            // update mean value on UI
            tvMedian.text = getString(R.string.median, median.toString())
        })
    }
}
