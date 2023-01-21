package bowling;

public class BowlingGame {
  private int totalScore = 0;
  private int[] rolls = new int[21];
  private int counter = 0;
  public void roll(int pins) {
    if(pins < 0 || pins > 10){
      throw new IllegalArgumentException("Üngültige Wurf");
    }
    if (counter>20 ){
      return;
    }
    rolls[counter] = pins;
    counter++;
  }
  public void roll(int pins, int times) {
    for (int i = 0; i < times; i++) {
      roll(pins);
    }
  }

  public int score() {
    int index = 0;
    for (int frame = 0; frame < 10; frame++) {

      if (isStrike(index)) {
        totalScore += 10 + rolls[index + 1] + rolls[index + 2];
        System.out.println("strike " + index);
        index++;
      } else if (isSpare(index)) {
        totalScore += 10 + rolls[index + 2];
        System.out.println("spare "+index);
        index += 2;
      } else {
        if((rolls[index]+rolls[index+1])>10){
          throw new IllegalArgumentException("Man kann nicht mehr als 10 Pins per Frame umwerfen");
        }
        totalScore += rolls[index] + rolls[index + 1];
        System.out.println("normal: "+index);
        index += 2;
      }
    }
    return totalScore;
  }

  private boolean isSpare(int index) {
    return (rolls[index] + rolls[index + 1]) == 10;
  }

  private boolean isStrike(int index) {
    return rolls[index] == 10;
  }
}
