package de.propra.defense.units;

import de.propra.defense.ui.GamePanel;
import java.util.Optional;
import java.util.Set;

public class Scarecrow extends AbstractUnit {

  public Scarecrow(GamePanel game, int row, int col) {
    super(game, row, col);
  }

  @Override
  public void act(Set<AbstractUnit> units) {
    Optional<AbstractUnit> abstractUnit = nearestOfType(Crow.class, units);
    if (abstractUnit.isPresent()) {
      Crow crow = (Crow) abstractUnit.get();
      if (isNeighbor(crow, 2)) {
        crow.scare();
      }
    }
  }

  @Override
  public boolean isEnemy() {
    return false;
  }
}
