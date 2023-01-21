package de.propra.defense.units;

import de.propra.defense.ui.GamePanel;
import java.util.Optional;
import java.util.Set;

public class Frog extends AbstractUnit {
  public Frog(GamePanel game, int row, int col) {
    super(game, row, col);
    System.out.println("Frog placed");
    this.strength = 2;
  }

  @Override
  public void act(Set<AbstractUnit> units) {
    Optional<AbstractUnit> nearest = nearestOfType(AbstractBug.class, units);
    if (nearest.isPresent()) {
      AbstractUnit bug = nearest.get();
      if (isNeighbor(bug, 1)) {
        attack(bug);
        full += 0.21;
      }
      else {
        if (delay == (int) full) {
          moveTowards(bug);
          delay = 0;
        }
        else {
          delay++;
        }
      }
    }
  }

  @Override
  public boolean isEnemy() {
    return false;
  }

}
