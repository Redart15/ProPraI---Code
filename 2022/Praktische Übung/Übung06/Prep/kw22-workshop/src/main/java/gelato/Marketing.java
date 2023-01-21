package gelato;

import gelato.mail.DieMail;
import gelato.mail.Mail;
import gelato.wetter.DasWetter;
import gelato.wetter.Wetter;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.util.concurrent.TimeUnit.SECONDS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Marketing {

  private static final double CORONA_FACTOR = 0.13;
  public static final int SECHS_STUNDEN = 6 * 3600 * 1000;
  private final Connection connection;
//  private DasWetter wetter;
//  private LocalDateTime now;
//  private Mails marketingEmail;

  private Marketing(Connection connection/*, DasWetter wetter, LocalDateTime now, Mails marketingEmail*/) {
    this.connection = connection;
//    this.wetter = wetter;
//    this.now = now;
//    this marketingEmail = marketingEmail;
  }

  public static Marketing create() {
    try {
      Connection connection = DriverManager.getConnection("jdbc:derby:kunden");
      return new Marketing(connection);
    } catch (SQLException throwables) {
      System.err.println("Datenbankverbindung konnte nicht hergestellt werden.");
      System.exit(-1);
    }
    return null; // unerreichbar, der Compiler merkt es nur nicht
  }

  public List<Kunde> getKunden() {
    ArrayList<Kunde> kunden = new ArrayList<>();
    String sql = "SELECT * FROM kunden";
    try {
      PreparedStatement stmt = connection.prepareStatement(sql);
      ResultSet resultSet = stmt.executeQuery();
      while (resultSet.next()) {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("mail");
        Date date = resultSet.getDate("lastmail");
        Kunde kunde = new Kunde(id, name, email, date.toLocalDate());
        kunden.add(kunde);
      }
    } catch (SQLException throwables) {
      System.err.println("Fehler beim Laden der Kundendaten");
      System.exit(-1);
    }
    return kunden;
  }

// wetter und zeit rausgehollt aus sendMail
  private void sendMarketingMail(Kunde kunde,  DieMail mail, String adresse) {
    updateLastMailDate(kunde);
    sendMail(adresse, mail);
  }

  private void sendMail(String adresse, DieMail mail) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    Process process = null;
    try {
      process = processBuilder
          .command("java", "-jar", Paths.get("lib", "ext", "mail.jar").toString(), adresse,
              mail.getSubject(),
              mail.getBody())
          .redirectOutput(INHERIT)
          .redirectError(INHERIT)
          .start();
      process.waitFor(5, SECONDS);

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private Wetter wetterDaten() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    Process process = null;
    try {
      process = processBuilder
          .command("java", "-jar", Paths.get("lib", "ext", "wetter.jar").toString())
          .redirectError(INHERIT)
          .start();
      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = in.readLine();
      process.waitFor(5, SECONDS);
      System.out.println("WETTER: " + line);
      return new Wetter(line);

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return new Wetter("20 50");
  }

// Email wird nicht mehr hier erzeugt, nach create Email gepushed
  private String[] getMartketingEmail(String name, DasWetter wetter, LocalDateTime now) {
    DayOfWeek tag = now.getDayOfWeek();
    boolean frueh = now.getHour() > 6 && now.getHour() < 10;
    // Wetter Logic
    if (wetter.istHeiss() && wetter.istTrocken()) {
      if (frueh) {
        return granita(name);
      }
      return gelato(name);
    }
    else if (wetter.istKalt()) {
      return waffelnUndKaffee(name);
    }
    else {
      if (tag.equals(SATURDAY) || tag.equals(SUNDAY)) {
        return zuppaInglese(name);
      }
      if (tag.equals(MONDAY) || tag.equals(WEDNESDAY)) {
        return cassata(name);
      }
      if (tag.equals(TUESDAY) || tag.equals(THURSDAY)) {
        return tiramisu(name);
      }
      if (tag.equals(FRIDAY)) {
        return pannaCotta(name);
      }
    }
    return new String[]{"", ""};
  }

//######################################################################################################################
// Emails werde nicht mehr in Gerichten erzeugt wird nach getMartketingEmail gepushed
  private String[] pannaCotta(String name) {
    String subject = "Es gibt hausgemachte Panna Cotta";
    String body = String.format("Hallo %s,%n%nendlich ist Freitag! " +
        "Und zur Feier des Tages haben wir unsere hausgemachte Panna Cotta im Angebot.%n\n" +
        "Du hast die freie Wahl, ob du die original Panna Cotta mit herrlich frischem Kompptt " +
        "oder Caramellsoße haben willst.%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

  private String[] tiramisu(String name) {
    String subject = "Magst du ein leckeres Tiramisu?";
    String body = String.format("Hallo %s,%n%n" +
        "kann es etwas besseres geben, als ein Tiramisu nach Originalrezept mit frischer Mascarpone Creme? Wir haben heute " +
        "den Klassiker aus Italien im Angebot. Eine herrlich süße Schleckerei, die wir gerne mit einer Tasse Cappucino servieren." +
        "%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

  private String[] cassata(String name) {
    String subject = "Die Bombe aus Italien: Cassata";
    String body = String.format("Hallo %s,%n%n" +
        "unser hausgemachtes Cassata Eis ist der original Cassata alla siciliana nachempfunden. Sie besteht aus  Himbeer-, Vanille- und Schokoladeneis sowie kandierten Früchten%n%n" +
        "%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

  private String[] zuppaInglese(String name) {
    String subject = "Tante Irma hat Zuppa Inglese gemacht";
    String body = String.format("Hallo %s,%n%n" +
        "dieses Wochenende hat Tante Irma ihre berühmte Zuppa Inglese gemacht. Lass dir die Spezialität aus Italiens Norden nicht entgehen.%n%n" +
        "%n%nDas Angebot gilt nur solange unser Vorrat reicht.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

  private String[] waffelnUndKaffee(String name) {
    String subject = "Mistwetter? Egal!";
    String body = String.format("Hallo %s,%n%n" +
        "lass dich vom Regen und der Kälte nicht runterziehen. Wir haben genau das Richtige! Leckere hausgemachte Waffeln und einen großen Pott Kaffee.%n%n" +
        "%n%nKomm einfach vorbei und nimm eine Auszeit.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

  private String[] gelato(String name) {
    String subject = "Warm! Warm! Warm!";
    String body = String.format("Hallo %s,%n%n" +
        "ist dir auch so heiß? Wir haben genau das Richtige! Leckeres hausgemachtes Eis in Meisterqualität.%n%n" +
        "%n%nKomm einfach vorbei und kühl dich bei einem original italienischem Gelato ab.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

  private String[] granita(String name) {
    String subject = "Frühstücken wie in Sizilien?";
    String body = String.format("Hallo %s,%n%n" +
        "Wenn es in Sizilien warm ist, dann frühstücken wir ein Granita al limone. Ein fruchtiges Zitronensorbet und dazu gibt es ein Brioche und Espresso.%n%n" +
        "%n%nKomm vorbei und starte den Tag wie im Urlaub.%n%n" +
        "Wir freuen uns auf Dich!%nDein Team von Gelateria Giacomo%n", name);
    body += covid();
    return new String[]{subject, body};
//    return new Mail(subject, body);
  }

//######################################################################################################################
  private String covid() {
    return "\n\nPS Wir haben natürlich alles für die Hygiene getan. Unsere Tische haben einen Mindestabstand von 2.5m, wir haben Scheiben zwischen den Tischen und alle unsere Bedienungen tragen Masken.";
  }


  private void updateLastMailDate(Kunde kunde) {
    try {
      PreparedStatement stmt =
          connection.prepareStatement("UPDATE kunden SET lastmail = CURRENT_DATE WHERE id = ?");
      stmt.setLong(1, kunde.getId());
      stmt.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }


  public static void main(String[] args) throws InterruptedException, SQLException {


    System.out.println("Marketing Start");
    Marketing m = Marketing.create();

    DasWetter wetter = Wetter.wetterDaten();
    LocalDateTime now = LocalDateTime.now();
    DieMail mail;

    while (true) {
      System.out.println("Starte Marketing.");
      List<Kunde> kunden = m.getKunden();
      for (Kunde k : kunden) {
        if (k.isReadyToReceiveMail() && Math.random() < CORONA_FACTOR) {
          // wetter und zeit rausgehollt aus sendMarketingMail

          String[] marketingEmail = m.getMartketingEmail(k.getName(), wetter, now);
          String subject = marketingEmail[0];
          String body = marketingEmail[1];
          String adresse = k.getEmail();
          mail = new Mail(subject, body);
          m.sendMarketingMail(k, mail, adresse);
        }
      }
      System.out.println("Fertig! Schlafe für 6 Stunden");
      Thread.sleep(SECHS_STUNDEN);
    }
  }

}
