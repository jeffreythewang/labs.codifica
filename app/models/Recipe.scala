package models

case class RecipeTypes(types: Seq[String])

case class RecipeList(method: String, list: Seq[Recipe])

case class Recipe(
  author: String,
  method: String,
  relative_img_path: String,
  grind_setting: Int,
  beans_weight: Int,
  water_weight: Int,
  tasting_notes: String,
  directions: String
)

object JsonFormats {
  import play.api.libs.json.Json

  implicit val recipeFormat = Json.format[Recipe]
  implicit val recipeListFormat = Json.format[RecipeList]
}
