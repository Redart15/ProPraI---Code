package tennis;

public class TennisGame {
  private final String player1;
  private final String player2;

  int player1Score = 0;
  int player2Score = 0;

  public TennisGame(String player1, String player2) {
    if (player1.equals(player2)) throw new IllegalArgumentException("Can't play against yourself");
    this.player1 = player1;
    this.player2 = player2;
  }

  public String score() {
    if (player1Score == player2Score && player1Score > 3) return "Deuce";
    if (player1Won()) return "Game "+player1;
    if (player2Won()) return "Game "+player2;
    if (player1Score > 3 && player2Score >= 3 && player1Score > player2Score) return "Advantage "+player1;
    if (player1Score >= 3 && player2Score > 3 && player1Score < player2Score) return "Advantage "+player2;
    if (player1Score == player2Score) return name(player1Score) + "-All";
    return name(player1Score) + "-" + name(player2Score);
  }

  private boolean player2Won() {
    return player2Score - player1Score > 1 && player2Score > 3;
  }

  private boolean player1Won() {
    return player1Score - player2Score > 1 && player1Score > 3;
  }


  private String name(int points) {
    switch (points) {
      case 1: return "Fifteen";
      case 2: return "Thirty";
      case 3: return "Fourty";
      default: return "Love";
    }
  }

  public void point(String player) {
    if (player.equals(player1) && !player2Won()) player1Score++;
    if (player.equals(player2) && !player1Won()) player2Score++;
  }
}
