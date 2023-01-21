package de.propra.woche01.schleifen;

public class Rekursion {

  private void call(int i, int n) {
    if (i == n) return;
    System.out.println(i);
    call(i+1,n);
  }

  public static void main(String[] args) {
    Rekursion recurse = new Rekursion();
    recurse.call(0,100000);
  }



}
