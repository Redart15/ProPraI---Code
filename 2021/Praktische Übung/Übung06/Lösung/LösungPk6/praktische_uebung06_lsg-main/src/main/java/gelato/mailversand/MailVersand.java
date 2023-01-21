package gelato.mailversand;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.util.concurrent.TimeUnit.SECONDS;


import gelato.db.Kunde;
import java.io.IOException;

public class MailVersand {

  public void sendMail(Mail mail, Kunde kunde) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    Process process = null;
    try {
      process = processBuilder
          .command("java", "-jar", "bin/mail.jar", kunde.getEmail(), mail.getSubject(), mail.getBody())
          .redirectOutput(INHERIT)
          .redirectError(INHERIT)
          .start();
      process.waitFor(5, SECONDS);

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }



}
