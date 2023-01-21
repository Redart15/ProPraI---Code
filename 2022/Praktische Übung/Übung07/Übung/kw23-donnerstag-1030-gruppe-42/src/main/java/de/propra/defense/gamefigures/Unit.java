package de.propra.defense.gamefigures;




import de.propra.defense.ui.GamePanel;

import java.util.Set;

public abstract class Unit {

  protected final GamePanel game;
  protected final String type;
  protected int delay;
  protected double full = 0;
  protected int row;
  protected int col;

  protected int hitpoints;
  protected int strength;

  public Unit(GamePanel game, String type, int row, int col) {
    this.game = game;
    this.type = type;
    this.row = row;
    this.col = col;
  }

  public void placeUnit(int row, int col) {
    if (game.occupied(row, col)) return;
    game.removeUnit(this.row, this.col);
    game.placeUnit(type, row, col);
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public boolean isStationary() {
    return type.equals("PLANT") || type.equals("SCARECROW");
  }

  public boolean isLivingPlant() {
    return type.equals("PLANT") && hitpoints > 0;
  }

  public boolean isLivingBug() {
    return (type.equals("BUG1") || type.equals("BUG2")) && hitpoints > 0;
  }

  public boolean isLivingEnemy() {
    return (type.equals("BUG1") || type.equals("BUG2") || type.equals("CROW")) && hitpoints > 0;
  }
  public boolean isLivingCrow() {
    return (type.equals("CROW")) && hitpoints > 0;
  }

  public void act(Set<Unit> units) {}


  protected void moveRandomly() {
    placeUnit(randomWalk(row), randomWalk(col));
  }

  protected void moveTowards(Unit other) {
    int nextrow = row;
    int nextcol = col;
    if (row < other.row) nextrow++;
    if (row > other.row) nextrow--;
    if (col < other.col) nextcol++;
    if (col > other.col) nextcol--;
    placeUnit(nextrow, nextcol);
  }

  private int randomWalk(int r) {
    if (Math.random() < 0.25) return r - 1;
    if (Math.random() > 0.75) return r + 1;
    return r;
  }


  protected void attack(Unit other) {
    System.out
        .println(this.type + " hits " + other.type + " Remaining Hitpoints: " + other.hitpoints);
    other.hit(strength);
  }

  private void hit(int strength) {
    hitpoints -= strength;
  }

  protected boolean isNeighbor(Unit other, int dist) {
    return Math.abs(row - other.row) <= dist &&
        Math.abs(col - other.col) <= dist;
  }

  protected int distance(Unit me, Unit a, Unit b) {
    var d1 = distance(me, a);
    var d2 = distance(me, b);
    return Double.compare(d1, d2);
  }

  private double distance(Unit me, Unit b) {
    return Math.sqrt(square(me.row - b.row) + square(me.col - b.col));
  }

  private double square(int v) {
    return v * v;
  }

  public boolean isDead() {
    return hitpoints <= 0;
  }

  public boolean isAlive() {
    return hitpoints > 0;
  }
}
