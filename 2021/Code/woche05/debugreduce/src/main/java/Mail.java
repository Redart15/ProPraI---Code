public class Mail {
  private final String user;
  private final String domain;
  public Mail(String adresse) {
    String[] split = adresse.split("@");
    user = split[0];
    domain = split[1];
  }

  public String getTopLevelDomain() {
    String[] elemente = domain.split("\\.");
    return elemente[elemente.length-1];
  }


}
