public class StripTags {

  public static String removeTags(String text) {
    StringBuffer result = new StringBuffer();
    boolean quote = false, tag = false;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '"') {
        quote = !quote;
      }
      else if (c == '<' && !quote) {
        tag = true;
      }
      else if (c == '>' && !quote) {
        tag = false;
      }
      else if (!tag) result.append(c);
    }
    return result.toString();
  }


}
