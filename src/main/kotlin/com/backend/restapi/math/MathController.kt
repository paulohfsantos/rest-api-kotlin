package com.backend.restapi.math

import com.backend.restapi.converters.ConvertToDouble
import com.backend.restapi.converters.IsNumeric
import com.backend.restapi.exception.UnsupportedMathOperation
import com.backend.restapi.math_simple.BasicMathOperations
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {

    private val numeric = IsNumeric()
    private val convert = ConvertToDouble()
    private val basicMath: BasicMathOperations = BasicMathOperations()

    @RequestMapping(value = ["/sum/{numOne}/{numTwo}"])
    fun sum(
        @PathVariable(value = "numOne") numOne: String?,
        @PathVariable(value = "numTwo") numTwo: String?
    ): Double {
        if (!numeric.isNumeric(numOne) || !numeric.isNumeric(numTwo))
            throw UnsupportedMathOperation("please, set a numeric value")

        return basicMath.sum(
            convert.convertToDouble(numOne),
            convert.convertToDouble(numTwo)
        )
    }

    @RequestMapping(value = ["/subtraction/{numOne}/{numTwo}"])
    fun subtraction(
        @PathVariable(value = "numOne") numOne: String?,
        @PathVariable(value = "numTwo") numTwo: String?
    ): Double {
        if (!numeric.isNumeric(numOne) || !numeric.isNumeric(numTwo))
            throw UnsupportedMathOperation("please, set a numeric value")

        return basicMath.subtraction(
            convert.convertToDouble(numOne),
            convert.convertToDouble(numTwo)
        )
    }

    @RequestMapping(value = ["/multiplication/{numOne}/{numTwo}"])
    fun multiplication(
        @PathVariable(value = "numOne") numOne: String?,
        @PathVariable(value = "numTwo") numTwo: String?
    ): Double {
        if (!numeric.isNumeric(numOne) || !numeric.isNumeric(numTwo))
            throw UnsupportedMathOperation("please, set a numeric value")

        return basicMath.multiplication(
            convert.convertToDouble(numOne),
            convert.convertToDouble(numTwo)
        )
    }

    @RequestMapping(value = ["/division/{numOne}/{numTwo}"])
    fun division(
        @PathVariable(value = "numOne") numOne: String?,
        @PathVariable(value = "numTwo") numTwo: String?
    ): Double {
        if (!numeric.isNumeric(numOne) || !numeric.isNumeric(numTwo))
            throw UnsupportedMathOperation("please, set a numeric value")

        return basicMath.division(
            convert.convertToDouble(numOne),
            convert.convertToDouble(numTwo)
        )
    }

    @RequestMapping(value = ["/average/{numOne}/{numTwo}"])
    fun average(
        @PathVariable(value = "numOne") numOne: String?,
        @PathVariable(value = "numTwo") numTwo: String?
    ): Double {
        if (!numeric.isNumeric(numOne) || !numeric.isNumeric(numTwo))
            throw UnsupportedMathOperation("please, set a numeric value")

        return basicMath.average(
            convert.convertToDouble(numOne),
            convert.convertToDouble(numTwo)
        )
    }

    @RequestMapping(value = ["/square/{numOne}"])
    fun square(
        @PathVariable(value = "numOne") numOne: String?,
    ): Double {
        if (!numeric.isNumeric(numOne))
            throw UnsupportedMathOperation("please, set a numeric value")

        return basicMath.square(
            convert.convertToDouble(numOne)
        )
    }
}