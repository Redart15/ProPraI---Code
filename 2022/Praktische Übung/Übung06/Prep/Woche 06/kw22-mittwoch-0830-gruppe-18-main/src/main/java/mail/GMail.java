package mail;

import gelato.Kunde;
import wetter.Wetter;
import wetter.WetterGetter;


import java.io.IOException;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.time.DayOfWeek.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class GMail {

    public void sendMail(Kunde kunde, Mail mail) {
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
