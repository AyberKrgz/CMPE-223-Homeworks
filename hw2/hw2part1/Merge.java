    //--------------------------------------------------------------------------
    // Title: Merge
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: Merge sort class with descending sort modifications.
    //--------------------------------------------------------------------------

public class Merge {
    
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){

        for (int k = lo; k <= hi; k++){
        aux[k] = a[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){ 
                a[k] = aux[j++]; 
            }
            else if (j > hi){
                a[k] = aux[i++]; 
            }
            else if (less(aux[j], aux[i])){
                a[k] = aux[j++]; 
            }
            else{ 
                a[k] = aux[i++]; 
            }
        }
        
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo){ return; }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);                                                      //sort left half
        sort(a, aux, mid+1, hi);                                                    //sort right half
        merge(a, aux, lo, mid, hi);                                                 //merge halves
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    //Methods below for sorting the parameter array in descending order.

    public static void sortDescending(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sortDescending(a, aux, 0, a.length - 1);
    }

    private static void sortDescending(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo){ return; }
        int mid = lo + (hi - lo) / 2;
        sortDescending(a, aux, lo, mid);                                                      //sort left half
        sortDescending(a, aux, mid+1, hi);                                                    //sort right half
        mergeDescending(a, aux, lo, mid, hi);                                                 //merge halves
    }

    public static void mergeDescending(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){

        for (int k = lo; k <= hi; k++){
        aux[k] = a[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){ 
                a[k] = aux[j++]; 
            }
            else if (j > hi){
                a[k] = aux[i++]; 
            }
            else if (less(aux[i], aux[j])){
                a[k] = aux[j++]; 
            }
            else{ 
                a[k] = aux[i++]; 
            }
        }
        
    }



}
