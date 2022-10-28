package com.backend.restapi.math

import com.backend.restapi.exception.UnsupportedMathOperation
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    @RequestMapping(value = ["/sum/{numOne}/{numTwo}"])
    fun sum(
        @PathVariable(value = "numOne") numOne: String?,
        @PathVariable(value = "numTwo") numTwo: String?
    ): Double {
        if (!isNumeric(numOne) || !isNumeric(numTwo))
            throw UnsupportedMathOperation("please, set a numeric value")

        return convertToDouble(numOne) + convertToDouble(numTwo)
    }

    private fun isNumeric(strNum: String?): Boolean {
        if (strNum.isNullOrBlank()) return false

        val num = strNum.replace(",".toRegex(), ".")
        return num.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

    private fun convertToDouble(strNum: String?): Double {
        if (strNum.isNullOrBlank()) return 0.0

        val num = strNum.replace(",".toRegex(), ".")
        print(num)
        return if (isNumeric(num)) num.toDouble() else 0.0
    }
}