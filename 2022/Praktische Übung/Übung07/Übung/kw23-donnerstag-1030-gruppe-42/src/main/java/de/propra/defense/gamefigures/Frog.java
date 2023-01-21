package de.propra.defense.gamefigures;

import de.propra.defense.ui.GamePanel;

import java.util.Optional;
import java.util.Set;

public class Frog extends Unit {

    public Frog(GamePanel game, String type, int row, int col){
        super(game,type,row,col);
        hitpoints = 1;
        strength = 2;
    }
    public String getType() {
        return "FROG";
    }


    public void act(Set<Unit> units) {
      Optional<Unit> nearest =
          units.stream().filter(Unit::isLivingBug).min((o1, o2) -> distance(this, o1, o2));
      if (nearest.isPresent()) {
        Unit bug = nearest.get();
        if (isNeighbor(bug, 1)) {
          attack(bug);
          full += 0.21;
        }
        else {
          if (delay == (int)full) {
            moveTowards(bug);
            delay = 0;
          }
          else {
            delay++;
          }
        }
      }
    }
}
