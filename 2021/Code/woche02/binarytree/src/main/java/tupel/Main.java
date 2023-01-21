package tupel;

public class Main {

    public static void repeat(ObjectTupel t) {
        if (t.getFirst() instanceof Character &&
                t.getSecond() instanceof Integer) {
            for (int i = 0; i < (Integer) t.getSecond(); i++) {
                System.out.print((Character) t.getFirst());
            }
        }
        else {
            // ??? Keine Ahnung, was hier zu tun ist
        }
    }

    public static void repeat(Tupel<Character, Integer> tupel) {
        // Keine Casts und Absicherung notwendig
        // der Compiler verhindert falsche Typen
        for (int i = 0; i < tupel.getSecond(); i++) {
            System.out.print(tupel.getFirst());
        }
    }

    public static void main(String[] args) {

        ObjectTupel t1 = new ObjectTupel('f', 4);
        repeat(t1);

        ObjectTupel t1fail = new ObjectTupel("f", 3);
        repeat(t1fail);

        Tupel<Character, Integer> t2 = new Tupel<>('o', 10);
        repeat(t2);



//        Tupel<Character, Integer> t2fail1 = new Tupel<>("o", 10);

        Tupel<String, Integer> t2fail2 = new Tupel<>("0", 10);
 //       repeat(t2fail2);

    }
}
