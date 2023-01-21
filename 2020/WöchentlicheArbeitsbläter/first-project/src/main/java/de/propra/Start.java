package de.propra;

import java.util.HashMap;

public class Start{
    public static void main(String[] args) {
         HashMap<String,Integer> einkaufliste  = new HashMap<>();
        einkaufliste.put("Banane", 10);
        einkaufliste.put("Computer", 230);
        einkaufliste.put("Iphone 13", 400);
        System.out.println(einkaufliste);
        System.out.println("hello");
    }
}