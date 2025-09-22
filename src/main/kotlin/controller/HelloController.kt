package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalTime

@Controller
class HelloController(
    @param:Value("\${app.message:Hello World}") 
    private val message: String
) {
    @GetMapping("/")
    fun welcome(
        model: Model,
        @RequestParam(defaultValue = "") name: String
    ): String {
        val timeGreeting = getTimeGreeting()
        val greeting = if (name.isNotBlank()) "$timeGreeting, $name!" else message
        model.addAttribute("message", greeting)
        model.addAttribute("name", name)
        return "welcome"
    }

    /** Helper method to return greeting based on the current time
     *       Morning    -> 05:00 - 11:59
     *       Afternoon  -> 12:00 - 17:59
     *       Evening    -> 18:00 - 20:59
     *       Night      -> 21:00 - 04:59
     */
    private fun getTimeGreeting(): String {
        val time = LocalTime.now().hour
        var greeting = ""

        if (time in 5..11) {
            greeting = "Good morning"
        } else if (time in 12..17) {
            greeting = "Good afternoon"
        } else if (time in 18..20) {
            greeting = "Good evening"
        } else {
            greeting = "Good night"
        }
        return greeting
    }
}

@RestController
class HelloApiController {
    
    @GetMapping("/api/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloApi(@RequestParam(defaultValue = "World") name: String): Map<String, String> {
        val greeting = getApiTimeGreeting()
        return mapOf(
            "message" to "$greeting, $name!",
            "timestamp" to java.time.Instant.now().toString()
        )
    }

    /** Helper method duplicated */
    private fun getApiTimeGreeting(): String {
        val time = LocalTime.now().hour
        var greeting = ""

        if (time in 5..11) {
            greeting = "Good morning"
        } else if (time in 12..17) {
            greeting = "Good afternoon"
        } else if (time in 18..20) {
            greeting = "Good evening"
        } else {
            greeting = "Good night"
        }
        return greeting
    }
}
