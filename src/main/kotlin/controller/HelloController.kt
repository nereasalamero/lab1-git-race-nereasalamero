package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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
        val greeting = if (name.isNotBlank()) "Hello, $name!" else message
        model.addAttribute("message", greeting)
        model.addAttribute("name", name)
        return "welcome"
    }
<<<<<<< Updated upstream
=======

    /** Helper method to return greeting based on the current time
     *       Morning    -> 05:00 - 11:59
     *       Afternoon  -> 12:00 - 17:59
     *       Evening    -> 18:00 - 20:59
     *       Night      -> 21:00 - 04:59
     */
    private fun getTimeGreeting(): String {
        val time = LocalTime.now().hour
        return when (time) {
            in 5..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            in 18..20 -> "Good evening"
            else -> "Good night"
        }
    }
>>>>>>> Stashed changes
}

@RestController
class HelloApiController {
    
    @GetMapping("/api/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloApi(@RequestParam(defaultValue = "World") name: String): Map<String, String> {
        return mapOf(
            "message" to "Hello, $name!",
            "timestamp" to java.time.Instant.now().toString()
        )
    }
<<<<<<< Updated upstream
=======

    /** Helper method duplicated */
    private fun getApiTimeGreeting(): String {
        val time = LocalTime.now().hour

        return when (time) {
            in 5..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            in 18..20 -> "Good evening"
            else -> "Good night"
        }
    }
>>>>>>> Stashed changes
}
