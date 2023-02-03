package com.backend.restapi.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.*

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(ex: String?): RuntimeException(ex)