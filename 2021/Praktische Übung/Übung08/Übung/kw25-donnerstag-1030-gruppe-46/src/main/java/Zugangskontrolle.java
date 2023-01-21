import network.Netzwerk;
import scanner.Scanner;

public class Zugangskontrolle {

  public static void main(String[] args) {
    // Dieser Code funktioniert nicht, da die Implementierungen von Scanner und Netzwerk
    // von einem anderen Team entwickelt werden und noch nicht fertiggestllt sind

    // Der Code soll nur demonstrieren, wie das Programm benutzt werden soll

    Netzwerk net = null;
    Scanner sc1 = null;
    Scanner sc2 = null;
    Zugangspunkt zp1 = new Zugangspunkt(10, 3, 0, net, sc1);
    Zugangspunkt zp2 = new Zugangspunkt(10, 3, 0, net, sc2);

    zp1.start();
    zp2.start();

  }

}
