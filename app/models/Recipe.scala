package models

case class Recipe(method: String,
                  grindSetting: Int,
                  beansWeight: Int,
                  waterWeight: Int,
                  tastingNotes: String)

object JsonFormats {
  import play.api.libs.json.Json

  implicit val recipeFormat = Json.format[Recipe]
}
