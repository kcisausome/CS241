//Name: Casey Au
//class : cs241
//date: 11-16-16

public class QuickSort implements SortAlgorithm {
  private double[] temp;// instance variable to help out so i can access the array around the class
  private SortTimer time;

  public void sort(double[] a, SortTimer t){
    temp = a;
    time = t;
    quickSort(0, temp.length - 1);
  }

  private void quickSort(int left, int right) {
    if (left < right) {
      int pivot = (left + right) / 2;// picks pivot from the middle of the array
      pivot = partition(left, right, pivot);
      quickSort(left, pivot - 1);
      quickSort(pivot + 1, right);
    }
  }

  private int partition(int left, int right, int pivotI) {// returns index of
                              // pivot after
                              // sorting
    // swapping pivot with element at position right, 3 moves
    double holder = temp[pivotI];
    temp[pivotI] = temp[right];
    temp[right] = holder;

    time.addMoves(3);

    int pivotIndex = right;// the pivot is really at the right, so this new
                // variable will make it easier to read
    int pos = left; // index of boundary between small and large elements,
            // pos and anything to the right is large

    for (int i = left; i < right; i++) {
      time.addComparison();
      if (temp[i] <= temp[pivotIndex]) {
        holder = temp[i];
        temp[i] = temp[pos];
        temp[pos] = holder;
        pos++;
        time.addMoves(3);
      }
    }

    holder = temp[pivotIndex];
    temp[pivotIndex] = temp[pos];
    temp[pos] = holder;

    time.addMoves(3);
    return pos;
  }

  public String toString() {
    String ar = "Quick Sort\n";
    return ar;
    /*
    for (int i = 0; i < temp.length; i++) {
      ar += temp[i] + " ";
    }
    return ar;
    */
  }
}
  


