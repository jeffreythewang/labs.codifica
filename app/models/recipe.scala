package models

import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._

import reactivemongo.api._
import reactivemongo.api.collections.default.BSONCollection
import reactivemongo.bson._

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import reactivemongo.core.commands.LastError

case class RecipeTypes(types: Seq[String])

case class RecipeList(method: String, list: Seq[Recipe])

case class Recipe(
  author: String,
  method: String,
  grind_setting: Int,
  beans_weight: Int,
  water_weight: Int,
  tasting_notes: String,
  directions: Seq[String]
)

object Recipe {

  private val collectionName = "recipes"

  implicit object RecipeBSONReader extends BSONDocumentReader[Recipe] {
    def read(doc: BSONDocument): Recipe =
      Recipe(
        doc.getAs[String]("author").getOrElse(""),
        doc.getAs[String]("method").getOrElse(""),
        doc.getAs[Int]("grind_setting").getOrElse(-1),
        doc.getAs[Int]("beans_weight").getOrElse(-1),
        doc.getAs[Int]("water_weight").getOrElse(-1),
        doc.getAs[String]("tasting_notes").getOrElse(""),
        doc.getAs[Seq[String]]("directions").getOrElse(Seq.empty[String])
      )
  }

  implicit object RecipeBSONWriter extends BSONDocumentWriter[Recipe] {
    def write(recipe: Recipe): BSONDocument =
      BSONDocument(
        "author" -> recipe.author,
        "method" -> recipe.method,
        "grind_setting" -> recipe.grind_setting,
        "beans_weight" -> recipe.beans_weight,
        "water_weight" -> recipe.water_weight,
        "tasting_notes" -> recipe.tasting_notes,
        "directions" -> recipe.directions
      )
  }
}

object JsonFormats {
  import play.api.libs.json.Json

  implicit val recipeFormat = Json.format[Recipe]
  implicit val recipeListFormat = Json.format[RecipeList]
}
