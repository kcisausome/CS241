//Name: Casey Au
//class : cs241
//date: 11-16-16

public class HeapSort implements SortAlgorithm {
  
  private double[] temp;
  private SortTimer time;
  private int size;

  @Override
  public void sort(double[] a, SortTimer t) {
    // TODO Auto-generated method stub
    temp = a;
    time = t;
    size = a.length;
    heapify(temp);
    heapSort(a);
  }

  private void heapify(double[] a) {
    int k = (a.length / 2) - 1;// index of last node that has at least one
    // child
    for (int i = k; i >= 0; i--) {
      siftDown(i);
    }
  }

  private void siftDown(int a) {
    int b;
    int c = size / 2;

    while ((a < c) && (temp[largerChild(a)] > temp[a])) {
      time.addComparison();
      b = largerChild(a);
      swap(a, b);
      a = b;
    }
  }

  private void swap(int one, int two) {
    time.addMoves(3);
    double t = temp[one];
    temp[one] = temp[two];
    temp[two] = t;
  }

  private int largerChild(int a) {
    int leftChild = 2 * a + 1;
    int rightChild = 2 * a + 2;

    time.addComparison();
    if (size > rightChild && (temp[leftChild] < temp[rightChild])) {
      return rightChild;
    } else {
      return leftChild;
    }

  }

  private double[] heapSort(double[] a) {
    size = temp.length;
    for (int i = a.length - 1; i >= 1; i--) {
      swap(0, i);
      size--;
      siftDown(0);
    }
    return a;
  }

  public String toString() {
    String ar = "Heap Sort\n";
    //for (int i = 0; i < temp.length; i++) {
      //ar += temp[i] + " ";
    
    return ar;
  }
}

  


