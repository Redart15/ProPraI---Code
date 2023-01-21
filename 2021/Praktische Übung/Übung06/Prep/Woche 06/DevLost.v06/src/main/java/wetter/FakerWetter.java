package wetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import static java.lang.ProcessBuilder.Redirect.INHERIT;
import static java.util.concurrent.TimeUnit.SECONDS;

public class FakerWetter implements DasWetter {
    public Wetter wetterDaten(){
        return new Wetter("50 50");
    }
}

