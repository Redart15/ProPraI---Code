import static network.Action.ENTER;
import static network.Action.LEAVE;


import java.time.LocalDateTime;
import network.Action;
import network.Netzwerk;
import scanner.PersonCategory;
import scanner.Scanner;

@SuppressWarnings("ALL")
public class Zugangspunkt {
  private final int maximal;
  private final int reserve;
  private int aktuell;
  private final Netzwerk net;
  private final Scanner scanner;

  public Zugangspunkt(int maximal, int reserve, int aktuell, Netzwerk net,
                      Scanner scanner) {
    this.maximal = maximal;
    this.reserve = reserve;
    this.aktuell = aktuell;
    this.net = net;
    this.scanner = scanner;
  }

  class NetzwerkReceive implements Runnable {

    @Override
    public void run() {
      while (true) {
        if (net.readyToReceive()) {
          Action action = net.receiveMessageBlocking();
          if (action == LEAVE) {
            aktuell--;
          }
          else {
            aktuell++;
          }
        }
      }
    }
  }

  public void start() {
    new Thread(new NetzwerkReceive()).start();

    while (true) {
      scanner.waitForPerson();
      if (!scanner.personWantsToEnter()) {
        net.getLock();
        try {
          scanner.allowLeave();
          net.broadcastEvent(LEAVE);
        } finally {
          net.releaseLock();
        }
      }
      else {
        processEnter();
      }
    }
  }

  private void processEnter() {
    if (!scanner.scanCertificate()) {
      scanner.rejectAccess("Kein Zertifikat vorgewiesen");
    }
    if (!scanner.covidNegativeCertificate()) {
      scanner.sendAlert();
      return;
    }

    if (LocalDateTime.now()
        .isAfter(scanner.certificateDate().plusHours(5))) {
      scanner.certificateExpired();
      scanner.rejectAccess("Zertifikat ist abgelaufen");
      return;
    }

    processAcceptRequest();

  }

  private void processAcceptRequest() {
    net.getLock();
    try {
      PersonCategory category = scanner.category();
      switch (category) {
        case SONDERNUTZUNG:
          enterSondernutzung();
        case ANGESTELLT:
          enterAngestellt();
        default:
          enterNormal();
      }
    } finally {
      net.releaseLock();
    }
  }

  private void enterNormal() {
    if (maximal - reserve > aktuell) {
      // Zutritt gestatten
      aktuell++;
      net.broadcastEvent(ENTER);
      scanner.allowAccess();
    }
    else {
      scanner.rejectAccess("Der Bereich ist zur Zeit voll");
    }
  }

  private void enterAngestellt() {
    if (maximal > aktuell) {
      aktuell++;
      net.broadcastEvent(ENTER);
      scanner.allowAccess();
    }
    else {
      scanner.rejectAccess("Der Bereich ist zur Zeit voll");
    }
  }

  private void enterSondernutzung() {
    aktuell++;
    net.broadcastEvent(ENTER);
    scanner.allowAccess();
  }


}
