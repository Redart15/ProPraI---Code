package mail;

import gelato.Kunde;

import java.io.IOException;
import java.nio.file.Paths;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.util.concurrent.TimeUnit.SECONDS;

public class GMail implements IMail {
    public void sendMail(Kunde kunde, Mail mail) {
        //Mail mail = createMail(kunde.getName());
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process process = null;
        try {
            process = processBuilder
                    .command("java", "-jar", Paths.get("lib", "ext", "mail.jar").toString(), kunde.getEmail(),
                            mail.getSubject(),
                            mail.getBody())
                    .redirectOutput(INHERIT)
                    .redirectError(INHERIT)
                    .start();
            process.waitFor(5, SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
