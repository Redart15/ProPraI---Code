class EnglishNumber {

  private static final String[] ones = {
      " one", " two", " three", " four", " five",
      " six", " seven", " eight", " nine", " ten",
      " eleven", " twelve", " thirteen", " fourteen",
      " fifteen", " sixteen", " seventeen",
      " eighteen", " nineteen"
  };
  private static final String[] tens = {
      " twenty", " thirty", " forty", " fifty",
      " sixty", " seventy", " eighty", " ninety"
  };

  private static final String[] groups = {
      "",
      " thousand",
      " million",
      " billion",
      " trillion",
      " quadrillion",
      " quintillion"
  };

  private String string = new String();

  public String getString() {
    return string;
  }

  public EnglishNumber(long n) {

    for (int i = groups.length - 1; i >= 0; i--) {

      long cutoff =
          (long) Math.pow((double) 10,
              (double) (i * 3));

      if (n >= cutoff) {

        int thisPart = (int) (n / cutoff);

        if (thisPart >= 100) {
          string +=
              ones[thisPart / 100] +
                  " hundred";
          thisPart = thisPart % 100;
        }
        if (thisPart >= 20) {
          string += tens[(thisPart / 10) - 1];
          thisPart = thisPart % 10;
        }
        if (thisPart >= 1) {
          string += ones[thisPart];
        }

        string += groups[i];

        n = n % cutoff;

      }
    }

    if (string.length() == 0) {
      string = "zero";
    }
    else {
      string = string.substring(1);
    }
  }
}
