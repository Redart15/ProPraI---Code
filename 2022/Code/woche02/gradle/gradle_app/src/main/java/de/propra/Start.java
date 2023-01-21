package de.propra;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

public class Start {

public static void main(String[] args) {
    HashSetValuedHashMap<String, String> zuordnung = new HashSetValuedHashMap<>();

    zuordnung.put("a", "b");
    zuordnung.put("a", "c");
    zuordnung.put("b", "d");
    zuordnung.put("c", "e");

    System.out.println(zuordnung.get("a"));
    System.out.println(zuordnung);
}

}