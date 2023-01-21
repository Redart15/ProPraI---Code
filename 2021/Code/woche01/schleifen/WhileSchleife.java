package de.propra.woche01.schleifen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WhileSchleife {

  public static void main(String[] args)  {
    try(BufferedReader in =
            new BufferedReader(new FileReader("input.txt")))  {
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println("> " + line);
      }
    }
    catch (IOException e) {
      System.err.println("Ein Fehler ist beim Lesen der Datei aufgetreten.");
      e.printStackTrace();
    }
  }

}
