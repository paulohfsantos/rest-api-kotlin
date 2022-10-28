package com.backend.restapi.greetings

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingsController {
    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greetings")
    fun greetings(@RequestParam(value = "name", defaultValue = "World") name: String?): Greetings {
        return Greetings(counter.incrementAndGet(), "Hey, $name")
    }
}