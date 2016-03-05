package fr.sysf.sample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

/**
 * Created by florent on 05/03/2016.
 */
object Application extends App {
  SpringApplication.run(classOf[ApplicationConfig]);
}

@Configuration
@EnableAutoConfiguration
@ComponentScan(Array("fr.sysf.sample"))
@RestController
class ApplicationConfig {

  @RequestMapping(Array("/greeting"))
  def greeting: Greeting = {
    return new Greeting("Hello World!")
  }
}

class Greeting(var message: String) {

  def getMessage: String = {
    return this.message
  }

  def setMessage(message: String) {
    this.message = message
  }

}