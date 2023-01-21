package de.propra.defense.gamefigures;

import de.propra.defense.ui.GamePanel;

import java.util.Set;

public class Plant extends Unit {
    public Plant(GamePanel game, String type, int row, int col){
        super(game,type,row,col);
        hitpoints = 5;
        strength = 0;
    }


    public String getType() {
        return "PLANT";
    }

    public void act(Set<Unit> units) {}
}
