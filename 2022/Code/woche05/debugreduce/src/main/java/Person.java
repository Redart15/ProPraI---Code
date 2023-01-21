import java.util.Objects;
import org.apache.commons.csv.CSVRecord;

public class Person {
  private final String name, firstname, street, postalcode, city, login;
  private final Mail mail;

  public Person(CSVRecord record) {
    this.name = record.get(0);
    this.firstname = record.get(1);
    this.street = record.get(2);
    this.postalcode = record.get(3);
    this.city = record.get(4);
    this.mail = new Mail(record.get(5));
    this.login = record.get(6);
  }



  public String getName() {
    return name;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getStreet() {
    return street;
  }

  public String getPostalcode() {
    return postalcode;
  }

  public String getCity() {
    return city;
  }

  public Mail getMail() {
    return mail;
  }

  public String getLogin() {
    return login;
  }
}
