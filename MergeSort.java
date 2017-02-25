//Name: Casey Au
//class : cs241
//date: 11-16-16

public class MergeSort implements SortAlgorithm {
  private double[] temp;
  private double[] mirror;
  private SortTimer time;

  public void sort(double[] a, SortTimer t) {
    temp = new double[a.length];
    mirror = a;
    time = t;
    mergeSort(0, a.length - 1);
  }

  private void mergeSort(int leftIndex, int rightIndex) {
    if (leftIndex < rightIndex) {
      int mid = (leftIndex + rightIndex) / 2;
      mergeSort(leftIndex, mid);
      mergeSort(mid + 1, rightIndex);
      merge(leftIndex, mid, rightIndex);
    }
  }

  private void merge(int low, int mid, int high) {
    int index = 0;
    int cursorL = low;
    int cursorR = mid + 1;
    while ((cursorL <= mid) && (cursorR <= high)) {
      if (mirror[cursorL] < mirror[cursorR]) {
        temp[index] = mirror[cursorL];
        cursorL++;
       
        time.addComparison();
        time.addMove();
      } else if (mirror[cursorL] == mirror[cursorR]) {
        temp[index++] = mirror[cursorL];
        temp[index] = mirror[cursorR];
        cursorL++;
        cursorR++;

        time.addComparisons(2);
        time.addMoves(2);
      } else {
        temp[index] = mirror[cursorR];
        cursorR++;

        time.addComparisons(2);
        time.addMove();

      }
      index++;
    }

    if (cursorR > high) {
      for (int i = cursorL; i <= mid; i++) {// off by one
        temp[index] = mirror[i];
        index++;
        time.addMove();
      }
    } else {
      for (int i = cursorR; i <= high; i++) {// off by one
        temp[index] = mirror[i];
        index++;
        time.addMove();
      }
    }
    time.addComparison();// for cursorR>high

    index = 0;
    for (int i = low; i <= high; i++) {// copying elements back into mirror
      mirror[i] = temp[index++];
      time.addMove();
    }

  }

  public String toString() {
    String ar = "Merge Sort\n";
    return ar;
    /*for (int i = 0; i < mirror.length; i++) {
      ar += mirror[i] + " ";
    }
    return ar;
    */
  }

}
  


