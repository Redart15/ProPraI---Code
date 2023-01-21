package gelato.wetter;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.util.concurrent.TimeUnit.SECONDS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WetterDienstImpl implements WetterDienst {

  @Override
  public Wetter wetterDaten() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    Process process = null;
    try {
      process = processBuilder
          .command("java", "-jar", "bin/wetter.jar")
          .redirectError(INHERIT)
          .start();
      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = in.readLine();
      process.waitFor(5, SECONDS);
      System.out.println("WETTER: "+line);
      return new Wetter(line);

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return new Wetter("20 50");
  }

}
