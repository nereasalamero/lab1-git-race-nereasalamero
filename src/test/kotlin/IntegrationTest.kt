package es.unizar.webeng.hello

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import java.time.LocalTime

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate
    private fun greeting(): String {
        val currentTime = LocalTime.now().hour

        return when (currentTime) {
            in 5..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            in 18..20 -> "Good evening"
            else -> "Good night"
        }
    }

    @Test
    fun `should return home page with modern title and client-side HTTP debug`() {
        val response = restTemplate.getForEntity("http://localhost:$port/?lang=en", String::class.java)
        
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Modern Web App")
        assertThat(response.body).contains("Interactive HTTP Testing &amp; Debug")
        assertThat(response.body).contains("Client-Side Educational Tool")
    }

    @Test
    fun `should return personalized greeting when name is provided`() {
        val response = restTemplate.getForEntity("http://localhost:$port?name=Developer", String::class.java)
        
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("${greeting()}, Developer!")
    }

    @Test
    fun `should return API response with timestamp`() {
        val response = restTemplate.getForEntity("http://localhost:$port/api/hello?name=Test", String::class.java)
        
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.headers.contentType).isEqualTo(MediaType.APPLICATION_JSON)
        assertThat(response.body).contains("${greeting()}, Test!")
        assertThat(response.body).contains("timestamp")
    }

    @Test
    fun `should serve Bootstrap CSS correctly`() {
        val response = restTemplate.getForEntity("http://localhost:$port/webjars/bootstrap/5.3.3/css/bootstrap.min.css", String::class.java)
        
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("body")
        assertThat(response.headers.contentType).isEqualTo(MediaType.valueOf("text/css"))
    }

    @Test
    fun `should expose actuator health endpoint`() {
        val response = restTemplate.getForEntity("http://localhost:$port/actuator/health", String::class.java)
        
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("UP")
    }
    
    @Test
    fun `should display client-side HTTP debug interface`() {
        val response = restTemplate.getForEntity("http://localhost:$port?name=Student", String::class.java)
        
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Interactive HTTP Testing &amp; Debug")
        assertThat(response.body).contains("Client-Side Educational Tool")
        assertThat(response.body).contains("Web Page Greeting")
        assertThat(response.body).contains("API Endpoints")
        assertThat(response.body).contains("Health Check")
        assertThat(response.body).contains("Learning Notes")
    }

    /**
     * Tests in spanish
     */
    @Test
    fun `should return home page with modern title and client-side HTTP debug (spanish)`() {
        val response = restTemplate.getForEntity("http://localhost:$port/?lang=es", String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Aplicación Web Moderna")
        assertThat(response.body).contains("Pruebas interactivas y depuración HTTP")
        assertThat(response.body).contains("Herramienta educativa del cliente")
    }

    @Test
    fun `should display client-side HTTP debug interface (spanish)`() {
        val response = restTemplate.getForEntity("http://localhost:$port?name=Student&lang=es", String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Pruebas interactivas y depuración HTTP")
        assertThat(response.body).contains("Herramienta educativa del cliente")
        assertThat(response.body).contains("Saludo de la página web")
        assertThat(response.body).contains("Puntos de acceso API")
        assertThat(response.body).contains("Comprobador de salud")
        assertThat(response.body).contains("Notas de aprendizaje")
    }

    /**
     * Tests in french
     */
    @Test
    fun `should return home page with modern title and client-side HTTP debug (french)`() {
        val response = restTemplate.getForEntity("http://localhost:$port/?lang=fr", String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Application Web Moderne")
        assertThat(response.body).contains("Tests interactifs et Débogage HTTP")
        assertThat(response.body).contains("Outil éducatif Côté Client")
    }

    @Test
    fun `should display client-side HTTP debug interface (french)`() {
        val response = restTemplate.getForEntity("http://localhost:$port?name=Student&lang=fr", String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Tests interactifs et Débogage HTTP")
        assertThat(response.body).contains("Outil éducatif Côté Client")
        assertThat(response.body).contains("Salutation de la page web")
        assertThat(response.body).contains("Points d&#39;Accés API")
        assertThat(response.body).contains("Vérification de Santé")
        assertThat(response.body).contains("Notes d&#39;Apprentissage")
    }
}
