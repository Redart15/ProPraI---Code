class Frame {
  public int[] rollindex = new int[3];

  public Frame() {
    for (int i = 0; i < 3; i++) {
      rollindex[i] = -1;
    }
  }

  public int getTotal() {
    int tot = 0;
    for (int i = 0; i < 3; i++) {
      if (rollindex[i] != -1) {
        tot += Bowling.rolls[rollindex[i]];
      }
    }
    return tot;
  }
}
