package mail;

public class Gerichte {
    public static Mail pannaCotta(String name) {
        String subject = "Es gibt hausgemachte Panna Cotta";
        String body = String.format("Hallo %s,%n%nendlich ist Freitag! " +
                "Und zur Feier des Tages haben wir unsere hausgemachte Panna Cotta im Angebot.%n\n" +
                "Du hast die freie Wahl, ob du die original Panna Cotta mit herrlich frischem Kompptt " +
                "oder Caramellsoße haben willst.%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    public static Mail tiramisu(String name) {
        String subject = "Magst du ein leckeres Tiramisu?";
        String body = String.format("Hallo %s,%n%n" +
                "kann es etwas besseres geben, als ein Tiramisu nach Originalrezept mit frischer Mascarpone Creme? Wir haben heute " +
                "den Klassiker aus Italien im Angebot. Eine herrlich süße Schleckerei, die wir gerne mit einer Tasse Cappucino servieren." +
                "%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    public static Mail cassata(String name) {
        String subject = "Die Bombe aus Italien: Cassata";
        String body = String.format("Hallo %s,%n%n" +
                "unser hausgemachtes Cassata Eis ist der original Cassata alla siciliana nachempfunden. Sie besteht aus  Himbeer-, Vanille- und Schokoladeneis sowie kandierten Früchten%n%n" +
                "%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    public static Mail zuppaInglese(String name) {
        String subject = "Tante Irma hat Zuppa Inglese gemacht";
        String body = String.format("Hallo %s,%n%n" +
                "dieses Wochenende hat Tante Irma ihre berühmte Zuppa Inglese gemacht. Lass dir die Spezialität aus Italiens Norden nicht entgehen.%n%n" +
                "%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    public static Mail waffelnUndKaffee(String name) {
        String subject = "Mistwetter? Egal!";
        String body = String.format("Hallo %s,%n%n" +
                "lass dich vom Regen und der Kälte nicht runterziehen. Wir haben genau das Richtige! Leckere hausgemachte Waffeln und einen großen Pott Kaffee.%n%n" +
                "%n%nKomm einfach vorbei und nimm eine Auszeit.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    public static Mail gelato(String name) {
        String subject = "Warm! Warm! Warm!";
        String body = String.format("Hallo %s,%n%n" +
                "ist dir auch so heiß? Wir haben genau das Richtige! Leckeres hausgemachtes Eis in Meisterqualität.%n%n" +
                "%n%nKomm einfach vorbei und kühl dich bei einem original italienischem Gelato ab.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    public static Mail granita(String name) {
        String subject = "Frühstücken wie in Sizilien?";
        String body = String.format("Hallo %s,%n%n" +
                "Wenn es in Sizilien warm ist, dann frühstücken wir ein Granita al limone. Ein fruchtiges Zitronensorbet und dazu gibt es ein Brioche und Espresso.%n%n" +
                "%n%nKomm vorbei und starte den Tag wie im Urlaub.%n%n" +
                "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
        body += covid();
        return new Mail(subject, body);
    }

    private static String covid() {
        return "\n\nPS Wir haben natürlich alles für die Hygiene getan. Unsere Tische haben einen Mindestabstand von 2.5m, wir haben Scheiben zwischen den Tischen und alle unsere Bedienungen tragen Masken.";
    }
}
