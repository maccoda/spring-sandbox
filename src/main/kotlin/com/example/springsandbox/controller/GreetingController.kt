package com.example.springsandbox.controller

import com.example.springsandbox.model.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val template: String = "Hello, %s"
    var id: AtomicLong = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String ): Greeting {
        return Greeting(id.getAndIncrement(), template.format(name))
    }

    @RequestMapping("/")
    fun root(): String {
        return "You have reached a page"
    }
}