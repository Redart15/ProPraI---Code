package odyssee;

import java.util.ArrayList;
import java.util.List;

public class EintragSammler {

  final List<Eintrag> eintraege = new ArrayList<>();
  private String tempZeitstempel;

  public void reduce(String s) {
    if (tempZeitstempel == null) {
      // erste Zeile eines Eintrags aus der Textdatei verarbeiten
      tempZeitstempel = s;
    }
    else {
      // zweite Zeile eines Eintrags aus der Textdatei verarbeiten
      eintraege.add(new Eintrag(tempZeitstempel, s));
      tempZeitstempel = null;
    }
  }

  public void join(EintragSammler that) {
    this.eintraege.addAll(that.eintraege);
  }


}
