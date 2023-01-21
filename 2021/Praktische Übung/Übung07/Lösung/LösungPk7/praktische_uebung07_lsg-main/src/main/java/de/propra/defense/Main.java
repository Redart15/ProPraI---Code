package de.propra.defense;

import static de.propra.defense.ui.GamePanel.H;
import static de.propra.defense.ui.GamePanel.TSZ;
import static de.propra.defense.ui.GamePanel.W;


import de.propra.defense.ui.GamePanel;
import de.propra.defense.units.AbstractUnit;
import de.propra.defense.units.BugA;
import de.propra.defense.units.BugB;
import de.propra.defense.units.Crow;
import de.propra.defense.units.Frog;
import de.propra.defense.units.Plant;
import de.propra.defense.units.Scarecrow;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JFrame;


public class Main {

  Random random = new Random();

  private Set<AbstractUnit> units = new HashSet<>();

  private boolean running = true;

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }

  private void start() {
    GamePanel window = setupGamePanel();

    units.addAll(List.of(
        new Frog(window, 3, 6),

        new BugA(window, 9, 28),
        new BugB(window, 4, 22),
        new Crow(window, 10, 25),

        new Scarecrow(window, 12, 1),

        new Plant(window, 12, 2),
        new Plant(window, 12, 3),
        new Plant(window, 13, 2),
        new Plant(window, 13, 3)));


    initializePositions();

    while (running) {
      allUnitsAct();
      removeDeadUnits(window);
      window.repaint();
      sleep();
      checkGameEnd();
    }


  }

  private GamePanel setupGamePanel() {
    GamePanel window = new GamePanel("Bauer Defence");
    window.setSize(W * TSZ, H * TSZ);
    window.setLayout(new GridLayout(H, W));
    window.setResizable(false);
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    return window;
  }

  private void initializePositions() {
    for (AbstractUnit unit : units) {
      unit.placeUnit(unit.getRow(), unit.getCol());
    }
  }

  private void allUnitsAct() {
    units.stream().filter(AbstractUnit::isAlive).forEach(u -> u.act(units));
  }

  private void checkGameEnd() {
    long plantCount = units.stream()
        .filter(u -> Plant.class.isAssignableFrom(u.getClass()))
        .filter(AbstractUnit::isAlive)
        .count();
    if (plantCount == 0) {
      System.out.println("Spiel verloren");
      running = false;
      return;
    }

    long enemyCount = units.stream()
        .filter(AbstractUnit::isEnemy)
        .filter(AbstractUnit::isAlive)
        .count();
    if (enemyCount == 0) {
      System.out.println("Spiel gewonnen");
      running = false;
    }
  }

  private void sleep() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void removeDeadUnits(GamePanel window) {
    units.stream()
        .filter(AbstractUnit::isDead)
        .forEach(u -> window.removeUnit(u.getRow(), u.getCol()));

    units = units.stream().filter(AbstractUnit::isAlive).collect(Collectors.toSet());
  }


}
