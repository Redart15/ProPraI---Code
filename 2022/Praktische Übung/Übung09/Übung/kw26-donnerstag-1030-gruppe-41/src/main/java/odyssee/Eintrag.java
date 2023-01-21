package odyssee;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public record Eintrag(LocalDateTime time, int answertime) {

  public Eintrag(String time, String answertime) {
    this(parseTime(time), Integer.parseInt(answertime));
  }

  private static LocalDateTime parseTime(String time) {
    return LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(time)), TimeZone
        .getDefault().toZoneId());
  }
}
