package data

import models.Recipe

object Aeropress extends BrewMethod {

  val method = "Aeropress"

  val recipes = Seq(
    Recipe("Ritual", method, 9, 17, 225, "Bold, concentrated",
      Seq(
        "Bring filtered water to a boil.",
        "Place filter into the bottom of the brewing chamber, place aeropress over mug, rinse with hot water, and discard rinse water.",
        "Put ground coffee on top of the filter in the brewing chamber.",
        "Slowly pour 225 grams of water onto the grounds.",
        "Use a spoon to slowly paddle slurry front to back & left to right.",
        "Place a plunger into the chamber pushing in and slowly lifting up, creating a vacuum seal.",
        "Carefully take the aeropress and mug off the scale.",
        "At 1 minute plunge for 25 seconds, for a total brew time of 1:25-1:30 minutes.",
        "Stir and enjoy!"
      )
    )
  )
}
