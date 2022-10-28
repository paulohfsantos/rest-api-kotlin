package com.backend.restapi.converters
import com.backend.restapi.converters.IsNumeric

class ConvertToDouble {
    private val numeric = IsNumeric()

    fun convertToDouble(strNum: String?): Double {
        if (strNum.isNullOrBlank()) return 0.0

        val num = strNum.replace(",".toRegex(), ".")

        return if (numeric.isNumeric(num)) num.toDouble() else 0.0
    }
}