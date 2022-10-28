package com.backend.restapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestApiBackendApplication

fun main(args: Array<String>) {
	runApplication<RestApiBackendApplication>(*args)
}
