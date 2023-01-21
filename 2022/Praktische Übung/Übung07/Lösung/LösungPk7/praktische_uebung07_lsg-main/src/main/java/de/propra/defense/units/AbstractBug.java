package de.propra.defense.units;

import de.propra.defense.ui.GamePanel;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractBug extends AbstractUnit {

  public AbstractBug(GamePanel game, int row, int col) {
    super(game, row, col);
    hitpoints = 10;
    strength = 1;
  }

  @Override
  public void act(Set<AbstractUnit> units) {
    Optional<AbstractUnit> nearestPlant = nearestOfType(Plant.class, units);
    if (nearestPlant.isPresent()) {
      AbstractUnit plant = nearestPlant.get();
      if (isNeighbor(plant, 1)) {
        attack(plant);
      }
      else {
        double decide = Math.random();
        if (decide > 0.8) {
          moveRandomly();
        }
        else {
          moveTowards(plant);
        }
      }
    }
  }

  @Override
  public boolean isEnemy() {
    return true;
  }
}
