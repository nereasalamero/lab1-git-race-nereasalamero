package es.unizar.webeng.hello.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.ui.Model
import org.springframework.ui.ExtendedModelMap
import java.time.LocalTime
import java.util.Locale

class HelloControllerUnitTests {
    private lateinit var controller: HelloController
    private lateinit var model: Model

    private fun greeting(): String {
        val currentTime = LocalTime.now().hour

        return when (currentTime) {
            in 5..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            in 18..20 -> "Good evening"
            else -> "Good night"
        }
    }
    
    @BeforeEach
    fun setup() {
        controller = HelloController("Test Message")
        model = ExtendedModelMap()
    }
    
    @Test
    fun `should return welcome view with default message`() {
        val view = controller.welcome(model, "")
        
        assertThat(view).isEqualTo("welcome")
        assertThat(model.getAttribute("message")).isEqualTo("Test Message")
        assertThat(model.getAttribute("name")).isEqualTo("")
    }
    
    @Test
    fun `should return welcome view with time-based greeting`() {
        val view = controller.welcome(model, "Developer")
                assertThat(view).isEqualTo("welcome")
        assertThat(model.getAttribute("message")).isEqualTo("${greeting()}, Developer!")
        assertThat(model.getAttribute("name")).isEqualTo("Developer")
    }
    
    @Test
    fun `should return API response with timestamp`() {
        val apiController = HelloApiController()
        val response = apiController.helloApi("Test")

        assertThat(response).containsKey("message")
        assertThat(response).containsKey("timestamp")
        assertThat(response["message"]).isEqualTo("${greeting()}, Test!")
        assertThat(response["timestamp"]).isNotNull()
    }

    /**
     * Test in Spanish
     */
    @Test
    fun `should return welcome view with default message (spanish)`() {
        LocaleContextHolder.setLocale(Locale("es"))
        val view = controller.welcome(model, "")

        assertThat(view).isEqualTo("welcome")
        assertThat(model.getAttribute("message")).isEqualTo("Test Message")
        assertThat(model.getAttribute("name")).isEqualTo("")
    }

    /**
     * Test in French
     */
    @Test
    fun `should return welcome view with default message (french)`() {
        LocaleContextHolder.setLocale(Locale("fr"))
        val view = controller.welcome(model, "")

        assertThat(view).isEqualTo("welcome")
        assertThat(model.getAttribute("message")).isEqualTo("Test Message")
        assertThat(model.getAttribute("name")).isEqualTo("")
    }
}
