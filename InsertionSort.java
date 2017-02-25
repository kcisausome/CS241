//Name: Casey Au
//class : cs241
//date: 11-16-16

public class InsertionSort implements SortAlgorithm {
  private double[] temp;
  public void sort(double[] a, SortTimer t){
    for(int i = 1; i < a.length; i++){
      double x = a[i];
      int j = i -1; 
      while( j >= 0 && a[j] > x){
        a[j+1] = a[j];
        t.addMove();
        t.addComparison();
        j--;
      }
      a[j+1] = x;
      t.addMove();
     }
    temp = a;
  }
    
  public String toString(){
    String ar ="Insertion Sort\n";
    return ar;
    /*System.out.println("temp length: "+ temp.length);
    for(int i = 0; i<temp.length; i++){
      ar += temp[i] + " ";
    }
    return ar;
    */
  }
}
  


