package de.propra.defense.gamefigures;

import de.propra.defense.ui.GamePanel;

import java.util.Optional;
import java.util.Set;

public class Scarecrow extends Unit {


    public Scarecrow(GamePanel game, String type, int row, int col){
        super(game,type,row,col);
        hitpoints = 1;
        strength = 2;
    }

    public String getType() {
        return "SCARECROW";
    }

    public void act(Set<Unit> units) {
      Optional<Unit> nearest =
              units.stream().filter(Unit::isLivingCrow).min((o1, o2) -> distance(this, o1, o2));
      if (nearest.isPresent()) {
        Unit crow = nearest.get();
        if (isNeighbor(crow, 2)) {
          attack(crow);
          full += 0.21;
        }

      }
    }
}
