//Name: Casey Au
//class : cs241
//date: 11-16-16

public class SorterRunner {
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      exit();
    }
    new SorterRunner(args[0].charAt(0), Integer.parseInt(args[1]));
  }

  public static void exit() {
    System.out.println("Usage:Java Sorter letters(h,i,m,q) numbers(0-6)");
    System.exit(0);
  }

  public SorterRunner(char method, int p) {
    SortAlgorithm s = null;
    SortTimer t = new SortTimer();
    switch (method) {
    case 'h':
      s = new HeapSort();
      System.out.print(s);
      break;
    case 'i':
      s = new InsertionSort();
      System.out.print(s);
      break;
    case 'm':
      s = new MergeSort();
      System.out.print(s);
      break;
    case 'q':
      s = new QuickSort();
      System.out.print(s);
      break;
    default:
      System.out.print("invalid letter");
      exit();
    }

    System.out.println("n\tmicrosec\tcomp\t\tmoves");
    double[] a;

    // generate powers of 10
    for (int i = 1; i <= p; i++) {// make better variable names
      int n = (int)Math.pow(10, i);
      long time = 0;
      long comp = 0;
      long move = 0;
      // do 5 trials and take avg
      for (int j = 0; j < 5; j++) {
        a = randomArray(n);
        t.reset();
        s.sort(a, t);
        time += t.getElapsedTime();
        comp += t.getComparisons();
        move += t.getMoves();
        if (!verify(a)) {
          System.out.println("sort error");
          System.exit(0);
        }
        time = time / 5;
        comp = comp / 5;
        move = move / 5;
      }
      System.out.println(n + "\t" + time + "\t\t" + comp + "\t\t" + move);
    }
  }

  private double[] randomArray(int n) {
    double[] temp = new double[n];
    for (int i = 0; i < n; i++) {
      temp[i] = Math.random();
    }
    return temp;
  }

  private boolean verify(double[] input) {
    for (int i = 0; i < input.length - 1; i++) {
      if (input[i] > input[i + 1]) {
        return false;
      }
    }
    return true;
  }
}
  


