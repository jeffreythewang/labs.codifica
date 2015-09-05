package controllers

import java.io.FileReader
import javax.inject.{Singleton, Inject}
import javax.script.ScriptEngineManager

import play.api.Play
import play.api.Play.current
import play.api.mvc._

import org.slf4j.{LoggerFactory, Logger}

object Application extends Controller {

  def index = Action {

    val engine = new ScriptEngineManager(null).getEngineByName("nashorn")

    if (engine == null) {
      BadRequest("Nashorn script engine not found. Are you using JDK 8?")
    } else {
      engine.eval("var global = this;")
      engine.eval("var console = {error: print, log: print, warn: print};")

      engine.eval(new FileReader("target/web/web-modules/main/webjars/lib/react/react-with-addons.js"))
      engine.eval(new FileReader("target/web/public/main/js/App.js"))
      Ok(views.html.index())
    }

  }
}
