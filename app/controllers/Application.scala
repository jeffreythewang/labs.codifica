package controllers

import javax.inject.{Singleton, Inject}

import play.api.Play
import play.api.Play.current
import play.api.mvc._

import org.slf4j.{LoggerFactory, Logger}

@Singleton
class Application @Inject() extends Controller {

  private final val logger: Logger = LoggerFactory.getLogger(classOf[Application])

  def index = Action {
    logger.info("Serving index page...")

    Ok(views.html.index())
  }
}
