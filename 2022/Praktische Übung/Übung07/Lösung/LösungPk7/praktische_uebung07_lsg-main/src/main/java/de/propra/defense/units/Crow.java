package de.propra.defense.units;

import de.propra.defense.ui.GamePanel;
import java.util.Optional;
import java.util.Set;

public class Crow extends AbstractUnit {

  private int scared;
  private int scareCount = 0;

  public Crow(GamePanel game, int row, int col) {
    super(game, row, col);
    strength = 1;
  }

  @Override
  public void act(Set<AbstractUnit> units) {

    scared--;
    Optional<AbstractUnit> nearestBug = nearestOfType(AbstractBug.class, units);
    if (nearestBug.isPresent()) {
      AbstractUnit bug = nearestBug.get();
      if (isNeighbor(bug, 1)) {
        attack(bug);
        return;
      }
    }

    Optional<AbstractUnit> nearestPlant = nearestOfType(Plant.class, units);
    if (nearestPlant.isPresent()) {
      AbstractUnit plant = nearestPlant.get();
      if (scared > 0) {
        moveAwayFrom(plant);
      }
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

  private void moveAwayFrom(AbstractUnit other) {
    int nextrow = row;
    int nextcol = col;
    if (row > other.row && row < 14) {
      nextrow++;
    }
    if (row < other.row && row > 1) {
      nextrow--;
    }
    if (col > other.col) {
      nextcol++;
    }
    if (col < other.col) {
      nextcol--;
    }
    placeUnit(nextrow, nextcol);
  }

  @Override
  public boolean isEnemy() {
    return true;
  }

  public void scare() {
    if (Math.random() < 0.3) {
      return;
    }
    scareCount++;
    if (scareCount > 4) {
      scared = 20;
    }
    if (scareCount > 10) {
      hitpoints--;
      scareCount = 0;
    }
    else {
      this.scared = 1;
    }
  }
}
