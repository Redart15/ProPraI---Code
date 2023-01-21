package gelato.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KundenRepository {

  private final Connection connection;

  private KundenRepository(Connection connection) {
    this.connection = connection;
  }

  public static KundenRepository create() {
    try {
      Connection connection = DriverManager.getConnection("jdbc:derby:kunden");
      return new KundenRepository(connection);
    } catch (SQLException throwables) {
      System.err.println("Datenbankverbindung konnte nicht hergestellt werden.");
      System.exit(-1);
    }
    return null; // unerreichbar, der Compiler merkt es nur nicht
  }

  public void updateLastMailDate(Kunde kunde) {
    try {
      PreparedStatement stmt = connection.prepareStatement("UPDATE kunden SET lastmail = CURRENT_DATE WHERE id = ?");
      stmt.setLong(1, kunde.getId());
      stmt.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
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


}
