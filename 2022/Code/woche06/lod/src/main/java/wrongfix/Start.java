package wrongfix;

public class Start {

  public static void main(String[] args) {
    Produkt p1 = new Produkt(231);
    Produkt p2 = new Produkt(129);
    Position pos1 = new Position(5,p2);
    Position pos2 = new Position(2,p1);
    Position pos3 = new Position(2,p2);
    Rechnung r = new Rechnung(pos1,pos2,pos3);
    System.out.print(5*129+2*231+2*129);
    System.out.print(" = ");
    System.out.println(r.rechnungsBetrag());
  }
}
