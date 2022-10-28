package com.backend.restapi.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.*
import java.util.*

@ControllerAdvice
@RestController
class CustomExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(
        ex: Exception,
        req: WebRequest
    ): ResponseEntity<ExceptionResponse> {
         val exceptionResponse = ExceptionResponse(
             Date(),
             ex.message,
             req.getDescription(false)
         )

        return ResponseEntity<ExceptionResponse>(
            exceptionResponse,
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(UnsupportedMathOperation::class)
    fun handleBadRequestException(
        ex: Exception,
        req: WebRequest
    ): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(
            Date(),
            ex.message,
            req.getDescription(false)
        )

        return ResponseEntity<ExceptionResponse>(
            exceptionResponse,
            HttpStatus.BAD_REQUEST
        )
    }
}