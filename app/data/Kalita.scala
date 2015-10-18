package data

import models.Recipe

object Kalita extends BrewMethod {

  val method = "Kalita"

  val recipes = Seq(
    Recipe("Ritual", method, 35, 32, 500, "Aromatic, floral",
      Seq(
        "Bring filtered water to a boil.",
        "Carefully rinse the paper filter, being sure not to compromise the shape.",
        "Add the ground coffee to the wet filter.",
        "Bloom: Add 70 grams of water.",
        "First pour: At 45 seconds add 50 grams of water, bringing weight up to 120 grams. In order to add as much water as needed to brew bed, pour quickly and deliberately in a circle.",
        "Following pours: Continue adding pulses of approximately 50 grams of water at a time. There should be about 9 pulses in total (pour into the center if needed so as not to go above the line of coffee already created).",
        "Brew should reach 500 grams around 3 minutes.",
        "Brew should finish around 3:45 minutes.",
        "Stir and enjoy!"
      )
    )
  )
}
