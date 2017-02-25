//Name: Casey Au
//class : cs241
//date: 11-16-16

public class SortTimer {
  long comparisons, moves, time;

  void reset() {
    time = System.nanoTime();
  }

  void addComparison() {
    comparisons++;
  }

  void addComparisons(int n) {
    for (int i = 0; i < n; i++) {
      comparisons++;
    }
  }

  void addMove() {
    moves++;
  }

  void addMoves(int n) {
    for (int i = 0; i < n; i++) {
      moves++;
    }
  }

  long getComparisons() {
    return comparisons;
  }

  long getMoves() {
    return moves;
  }

  long getElapsedTime() {
    long endTime = System.nanoTime();
    long elapsedTime = endTime - time;
    elapsedTime = elapsedTime / 1000;
    return elapsedTime;
  }

}


  


