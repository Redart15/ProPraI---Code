package fixed;

public class Start {

  public static void main(String[] args) {
    Produkt p1 = new Produkt(400);
    Produkt p2 = new Produkt(100);
    Position pos1 = new Position(6,p2);
    Position pos2 = new Position(3,p1);
    Position pos3 = new Position(1,p2);
    Rechnung r = new Rechnung(pos1,pos2,pos3);
    System.out.print(6*100+3*400+1*100);
    System.out.print(" = ");
    System.out.println(r.rechnungsBetrag());
  }
}
