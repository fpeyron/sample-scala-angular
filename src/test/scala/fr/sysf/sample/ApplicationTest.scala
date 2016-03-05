package fr.sysf.sample

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.{TestRestTemplate, IntegrationTest, SpringApplicationConfiguration}
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

/**
 * Created by florent on 05/03/2016.
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[ApplicationConfig]))
@WebAppConfiguration
@IntegrationTest(Array("server.port:0"))
class ApplicationTest {

  @Value("${local.server.port}")
  private val port = 0

  @Test
  def homePageProtected {
    val response: ResponseEntity[String] = new TestRestTemplate().getForEntity("http://localhost:" + port + "/", classOf[String])
    assertEquals(HttpStatus.OK, response.getStatusCode)

  }
}
