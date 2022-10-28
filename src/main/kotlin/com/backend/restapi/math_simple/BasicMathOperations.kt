package com.backend.restapi.math_simple

import kotlin.math.sqrt

class BasicMathOperations {
    fun sum(numOne: Double, numTwo: Double) = numOne + numTwo

    fun subtraction(numOne: Double, numTwo: Double) = numOne - numTwo

    fun multiplication(numOne: Double, numTwo: Double) = numOne * numTwo

    fun division(numOne: Double, numTwo: Double) = numOne / numTwo

    fun average(numOne: Double, numTwo: Double) = (numOne + numTwo) / 2

    fun square(numOne: Double) = sqrt(numOne)
}