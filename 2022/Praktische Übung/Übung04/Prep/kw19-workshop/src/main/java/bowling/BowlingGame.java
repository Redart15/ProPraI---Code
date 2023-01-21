package bowling;

public class BowlingGame {
  private int[] scoreBoard = new int[21];
  private int currentRoll = 0;

  public void roll(int pointScored) {
    if (pointScored > 10 || pointScored < 0) {
      throw new IllegalArgumentException("Die Anzahl der getroffenen Kegel muss zwischen -1 und 11 liegen");
    }
    scoreBoard[currentRoll] = pointScored;
    currentRoll++;
  }

  public int score() {
    int totalScore = 0;
    int currentThrow = 0;
    for (int frame = 0; frame < 10; frame++) {
      if(scoreBoard[currentThrow]== 10){
        totalScore += 10 + scoreBoard[currentThrow+1] + scoreBoard[currentThrow+2];
        currentThrow++;
      }
      else if (scoreBoard[currentThrow]+scoreBoard[currentThrow+1]== 10){
        totalScore += 10 + scoreBoard[currentThrow+2];
        currentThrow +=2;
      }else{
        totalScore += scoreBoard[currentThrow]+scoreBoard[currentThrow+1];
        currentThrow +=2;
      }
    }
    return totalScore;
  }
}
