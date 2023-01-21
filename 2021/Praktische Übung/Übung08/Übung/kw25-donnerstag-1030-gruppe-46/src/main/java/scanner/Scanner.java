package scanner;

import java.time.LocalDateTime;

public interface Scanner {

  // Aufruf blockiert, bis eine Person den Bereich betreten
  // oder verlassen will
  void waitForPerson();

  // Nur aufrufen, wenn eine Person da ist
  // true: Person will rein
  // false: Person will raus
  boolean personWantsToEnter();

  // Nur aufrufen, wenn eine Person verlassen will
  // Muss immer gestattet werden!
  void allowLeave();

  // Starte den Scanning Prozess
  // gibt true zurück, wenn ein Zertifikat gescannt wurde
  // gibt false zurück, wenn die Person im Scanner den
  // Vorgang abgebrochen hat oder ein Timeout aufgetreten ist
  boolean scanCertificate();

  // Nur aufrufen, wenn das Zertifikat gescannt wurde
  // true <=> letzter Test ist negativ
  boolean covidNegativeCertificate();

  // Nur aufrufen, wenn das Zertifikat gescannt wurde
  // Zeitpunkt des Tests
  LocalDateTime certificateDate();

  // Status der Person (normal, angestellt, sonderrechte)
  // Nur aufrufen, wenn eine Person einteten will
  PersonCategory category();

  // Zugang gestatten
  void allowAccess();

  // Zugang verweigern und Meldung anzeigen
  // öffnet die Schleuse, so dass die Person den
  // Bereich verlassen kann, z.B. um ein neues Zertifikat zu holen
  void rejectAccess(String reason);

  // Alarm auslösen (positiv getestete Person)
  void sendAlert();

  void certificateExpired();

}