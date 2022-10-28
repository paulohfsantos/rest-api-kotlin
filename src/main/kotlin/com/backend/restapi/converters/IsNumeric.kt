package com.backend.restapi.converters

class IsNumeric {
    fun isNumeric(strNum: String?): Boolean {
        if (strNum.isNullOrBlank()) return false

        val num = strNum.replace(",".toRegex(), ".")
        return num.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}