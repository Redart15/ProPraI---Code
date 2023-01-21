package de.propra.defense.units;


import de.propra.defense.ui.GamePanel;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractUnit {
  protected final GamePanel game;

  protected int row;
  protected int col;
  protected int hitpoints = 1;
  protected int strength;
  protected double full = 0;
  protected int delay;

  public AbstractUnit(GamePanel game, int row, int col) {
    this.game = game;
    this.row = row;
    this.col = col;
  }

  public void placeUnit(int row, int col) {
    if (game.occupied(row, col)) {
      return;
    }
    game.removeUnit(this.row, this.col);
    game.placeUnit(this.getClass(), row, col);
    this.row = row;
    this.col = col;
  }

  protected Optional<AbstractUnit> nearestOfType(Class<? extends AbstractUnit> type,
                                                 Set<AbstractUnit> units) {
    return units.stream()
        .filter(u -> type.isAssignableFrom(u.getClass()))
        .filter(AbstractUnit::isAlive)
        .min((o1, o2) -> distance(this, o1, o2));
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public boolean isDead() {
    return hitpoints <= 0;
  }

  public boolean isAlive() {
    return hitpoints > 0;
  }

  public abstract void act(Set<AbstractUnit> units);

  protected int distance(AbstractUnit me, AbstractUnit a, AbstractUnit b) {
    var d1 = distance(me, a);
    var d2 = distance(me, b);
    return Double.compare(d1, d2);
  }

  private double distance(AbstractUnit me, AbstractUnit b) {
    return Math.sqrt(square(me.row - b.row) + square(me.col - b.col));
  }

  private double square(int v) {
    return v * v;
  }


  protected boolean isNeighbor(AbstractUnit other, int dist) {
    return Math.abs(row - other.row) <= dist &&
        Math.abs(col - other.col) <= dist;
  }

  protected void hit(int strength) {
    hitpoints -= strength;
  }

  protected void attack(AbstractUnit other) {
    System.out
        .println(
            this.getClass().getSimpleName() + " hits " + other.getClass().getSimpleName() +
                " Remaining Hitpoints: " +
                other.hitpoints);
    other.hit(strength);
  }

  protected void moveRandomly() {
    placeUnit(randomWalk(row), randomWalk(col));
  }

  protected void moveTowards(AbstractUnit other) {
    int nextrow = row;
    int nextcol = col;
    if (row < other.row) {
      nextrow++;
    }
    if (row > other.row) {
      nextrow--;
    }
    if (col < other.col) {
      nextcol++;
    }
    if (col > other.col) {
      nextcol--;
    }
    placeUnit(nextrow, nextcol);
  }

  private int randomWalk(int r) {
    if (Math.random() < 0.25) {
      return r - 1;
    }
    if (Math.random() > 0.75) {
      return r + 1;
    }
    return r;
  }

  public abstract boolean isEnemy();
}
