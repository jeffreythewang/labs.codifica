package data

import models.Recipe

trait BrewMethod {
  val method : String
  val recipes : Seq[Recipe]
}
