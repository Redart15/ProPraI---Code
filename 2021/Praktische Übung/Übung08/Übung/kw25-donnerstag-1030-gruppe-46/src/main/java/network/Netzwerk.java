package network;

public interface Netzwerk {

  // Fragt nach Schreibrechten für das Netzwerk
  // Wird vom Netzwerk erst erteilt, wenn alle
  // vorherigen Nachrichten von allen Zugangspunkten
  // verarbeitet wurden und kein anderer Zugangspunkt
  // momentan Schreibrechte hat

  // Wichtig: Die Implementierung eines solchen
  // verteilten Locks ist extrem schwierig!
  void getLock();

  // Gibt die Schreibrechte wieder frei
  void releaseLock();

  // Sendet eine Nachricht an alle anderen Zugangspunkte
  void broadcastEvent(Action event);

  // true <=> eine Nachricht ist vorhanden
  boolean readyToReceive();

  // Nächste Nachricht empfangen
  // Nur aufrufen, wenn eine Nachricht vorhanden ist
  Action receiveMessageBlocking();

}