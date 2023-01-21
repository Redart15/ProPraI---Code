package de.propra.defense.units;

import de.propra.defense.ui.GamePanel;
import java.util.Set;

public class Plant extends AbstractUnit {

  public Plant(GamePanel game, int row, int col) {
    super(game, row, col);
    hitpoints = 5;
  }

  @Override
  public void act(Set<AbstractUnit> units) {
    // just hanging around at the same old spot
  }

  @Override
  public boolean isEnemy() {
    return false;
  }

}
