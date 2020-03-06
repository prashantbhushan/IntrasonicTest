package com.prashant.intrasonictest.utility

/**
 * Extension method to round off decimal to 1 place
 */
fun Double.roundToNDecimalPlace(decimalPlace: Int) =
    String.format("%.${decimalPlace}f", this).toDouble()