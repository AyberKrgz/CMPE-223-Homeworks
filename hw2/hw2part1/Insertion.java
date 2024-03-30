    //--------------------------------------------------------------------------
    // Title: Insertion
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: Insertion sort class with the sortDescending modification.
    //--------------------------------------------------------------------------

public class Insertion {
    
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++){
            for (int j = i; j > 0; j--){

                if (less(a[j], a[j-1])){
                    exch(a, j, j-1);
                }
                else break;
            }
        }
    }

    public static void sortDescending(Comparable[] a){                  //This method sorts the parameter array in descending order.
        int N = a.length;
        for(int i=N; i>0; i--){
            for(int j=i; j<N; j++){

                if (less(a[j-1], a[j])){
                    exch(a, j-1, j);
                }
                else break;
            }
        }
    }




    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j){ 
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


}
