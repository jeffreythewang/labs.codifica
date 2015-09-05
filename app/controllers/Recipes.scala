package controllers

import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc._
import play.api.libs.json._

import org.slf4j.{LoggerFactory, Logger}
import javax.inject.Singleton
import scala.concurrent.Future

@Singleton
class Recipes extends Controller with MongoController {

  private final val logger: Logger = LoggerFactory.getLogger(classOf[Recipes])

  def collection: JSONCollection = db.collection[JSONCollection]("recipes")


  // case classes + JSON writes and reads
  import models._
  import models.JsonFormats._

  def createRecipe = Action.async(parse.json) { request =>
    request.body.validate[Recipe].map { recipe =>
      collection.insert(recipe).map { lastError =>
        logger.debug(s"Successfully inserted with LastError: $lastError")
        Created(s"Recipe Created")
      }
    }.getOrElse(Future.successful(BadRequest("invalid json")))
  }

  def getRecipes(recipeType: String) = Action.async {
    val cursor: Cursor[Recipe] = collection.
      find(Json.obj("type" -> recipeType)).
      cursor[Recipe]

    val futureRecipesList: Future[List[Recipe]] = cursor.collect[List]()

    val futureRecipesJsonArray: Future[JsArray] = futureRecipesList.map { recipes =>
      Json.arr(recipes)
    }

    futureRecipesJsonArray.map { recipes =>
      Ok(recipes(0))
    }
  }

}
