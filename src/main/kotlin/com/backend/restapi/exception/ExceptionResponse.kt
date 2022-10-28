package com.backend.restapi.exception

import java.util.Date

class ExceptionResponse (
    val timestamp: Date,
    val msg: String?,
    val details: String
)