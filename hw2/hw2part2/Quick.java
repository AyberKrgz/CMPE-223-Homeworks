    //--------------------------------------------------------------------------
    // Title: Quick
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: Quick sort class with descending sort modifications.
    //--------------------------------------------------------------------------

    public class Quick {
    
        private static int partition(Comparable[] a, int lo, int hi){
            int i = lo, j = hi+1;
            while (true){
    
                while (less(a[++i], a[lo])){
                    if (i == hi) break;
                }
    
                while (less(a[lo], a[--j])){
                    if (j == lo) break;
                }
    
                if (i >= j){ break; }
                exch(a, i, j);
    
            }
    
            exch(a, lo, j);
            return j;
    
        }
        public static void sort(Comparable[] a){
            StdRandom.shuffle(a);
            sort(a, 0, a.length - 1);
        }
    
        private static void sort(Comparable[] a, int lo, int hi){
            if (hi <= lo){ return; }
            int j = partition(a, lo, hi);
            sort(a, lo, j-1);
            sort(a, j+1, hi);
        }
    
        private static boolean less(Comparable v, Comparable w){
            return v.compareTo(w) < 0;
        }
        
        private static void exch(Comparable[] a, int i, int j){ 
            Comparable swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    
        //Methods below are for sorting the parameter array in descending order.
    
        private static int partitionDescending(Comparable[] a, int lo, int hi){
            int i = lo, j = hi+1;
            while (true){
    
                while (less(a[lo], a[++i])){
                    if (i == hi) break;
                }
    
                while (less(a[--j], a[lo])){
                    if (j == lo) break;
                }
    
                if (i >= j){ break; }
                exch(a, i, j);
    
            }
    
            exch(a, lo, j);
            return j;
    
        }
        public static void sortDescending(Comparable[] a){
            StdRandom.shuffle(a);
            sortDescending(a, 0, a.length - 1);
        }
    
        private static void sortDescending(Comparable[] a, int lo, int hi){
            if (hi <= lo){ return; }
            int j = partitionDescending(a, lo, hi);
            sortDescending(a, lo, j-1);
            sortDescending(a, j+1, hi);
        }
    
    
    }
    