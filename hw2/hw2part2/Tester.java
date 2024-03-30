    //----------------------------------------------------------------------------
    // Title: Tester
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: This is a tester driver class for "Method.java"
    //              It has 3 extra methods to "create random array", 
    //              "rearrange an ascending array as descending"
    //              and to "use the methods in Method.java and measure the time
    //              for these operations"
    //----------------------------------------------------------------------------

import java.util.Scanner;
import java.util.Random;
public class Tester {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a seed to create random generated values :");
        int seed = scan.nextInt();
        scan.close();
        
        System.out.println("Seed : " + seed);

        Random random = new Random(seed);


        Integer[] random1 = RandomArray(random,250);
        Integer[] random2 = RandomArray(random,1000);
        Integer[] random3 = RandomArray(random,4000);                           //Randomly generated arrays with certain sizes.
        Integer[] random4 = RandomArray(random,16000);
        Integer[] random5 = RandomArray(random,64000);

        Long[] selectionRandom = new Long[3];
        Long[] selectionAscend = new Long[3];                                       //Arrays to hold times spent during the executions of selection sort.
        Long[] selectionDescend = new Long[3];

        Long[] insertionRandom = new Long[3];
        Long[] insertionAscend = new Long[3];                                       //Arrays to hold times spent during the executions of insertion sort.
        Long[] insertionDescend = new Long[3];

        Long[] mergeRandom = new Long[3];
        Long[] mergeAscend = new Long[3];                                           //Arrays to hold times spent during the executions of merge sort.
        Long[] mergeDescend = new Long[3];

        Long[] quickRandom = new Long[3];
        Long[] quickAscend = new Long[3];                                           //Arrays to hold times spent during the executions of quick sort.
        Long[] quickDescend = new Long[3];
        
        Long[] noSortRandom = new Long[3];
        Long[] noSortAscend = new Long[3];                                          //Arrays to hold times spent during the executions of noSort.
        Long[] noSortDescend = new Long[3];



        //---------------------------------------------------------------
        //  THIS IS THE PART WHERE WE TEST THE ARRAYS FOR THE SIZE:250
        //  FOR THIS WE WILL USE "random1" ARRAY
        //---------------------------------------------------------------

        System.out.println("Input size: 250");

        System.out.println("\nSort option: Selection");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            selectionRandom[i] = timer(random1,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionRandom[i]);
        }

        System.out.println("Ascending");
        Integer[] arr = random1;
        Selection.sort(arr);

        for(int i=0;i<3; i++){
            selectionAscend[i] = timer(arr,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr);

        for(int i=0;i<3; i++){
            selectionDescend[i] = timer(arr,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------     

        System.out.println("\nSort option: Insertion");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            insertionRandom[i] = timer(random1,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionRandom[i]);
        }

        System.out.println("Ascending");
        arr = random1;
        Insertion.sort(arr);

        for(int i=0;i<3; i++){
            insertionAscend[i] = timer(arr,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr);

        for(int i=0;i<3; i++){
            insertionDescend[i] = timer(arr,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------        

        System.out.println("\nSort option: Merge");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            mergeRandom[i] = timer(random1,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeRandom[i]);
        }

        System.out.println("Ascending");
        arr = random1;
        Merge.sort(arr);

        for(int i=0;i<3; i++){
            mergeAscend[i] = timer(arr,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeAscend[i]);
        }

        System.out.println("Descending");
        descend(arr);

        for(int i=0;i<3; i++){
            mergeDescend[i] = timer(arr,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //-------------------------------------------------------------------- 

        System.out.println("\nSort option: Quick");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            quickRandom[i] = timer(random1,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickRandom[i]);
        }

        System.out.println("Ascending");
        arr = random1;
        Quick.sort(arr);

        for(int i=0;i<3; i++){
            quickAscend[i] = timer(arr,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickAscend[i]);
        }

        System.out.println("Descending");
        descend(arr);

        for(int i=0;i<3; i++){
            quickDescend[i] = timer(arr,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //-------------------------------------------------------------------- 

        System.out.println("\nSort option: NoSort");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            noSortRandom[i] = timer(random1,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortRandom[i]);
        }

        System.out.println("Ascending");
        arr = random1;
        Quick.sort(arr);

        for(int i=0;i<3; i++){
            noSortAscend[i] = timer(arr,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortAscend[i]);
        }

        System.out.println("Descending");
        descend(arr);

        for(int i=0;i<3; i++){
            noSortDescend[i] = timer(arr,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortDescend[i]);
        }


        //---------------------------------------------------------------
        //  THIS IS THE PART WHERE WE TEST THE ARRAYS FOR THE SIZE:1000
        //  FOR THIS WE WILL USE "random2" ARRAY
        //---------------------------------------------------------------       

        System.out.println("\nInput size: 1000");

        System.out.println("\nSort option: Selection");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            selectionRandom[i] = timer(random2,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionRandom[i]);
        }

        System.out.println("Ascending");
        Integer[] arr2 = random2;
        Selection.sort(arr2);

        for(int i=0;i<3; i++){
            selectionAscend[i] = timer(arr2,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr2);

        for(int i=0;i<3; i++){
            selectionDescend[i] = timer(arr2,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------         

        System.out.println("\nSort option: Insertion");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            insertionRandom[i] = timer(random2,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionRandom[i]);
        }

        System.out.println("Ascending");
        arr2 = random2;
        Insertion.sort(arr2);

        for(int i=0;i<3; i++){
            insertionAscend[i] = timer(arr2,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr2);

        for(int i=0;i<3; i++){
            insertionDescend[i] = timer(arr2,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------         

        System.out.println("\nSort option: Merge");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            mergeRandom[i] = timer(random2,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeRandom[i]);
        }

        System.out.println("Ascending");
        arr2 = random2;
        Merge.sort(arr2);

        for(int i=0;i<3; i++){
            mergeAscend[i] = timer(arr2,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeAscend[i]);
        }

        System.out.println("Descending");
        descend(arr2);

        for(int i=0;i<3; i++){
            mergeDescend[i] = timer(arr2,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //-------------------------------------------------------------------- 

        System.out.println("\nSort option: Quick");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            quickRandom[i] = timer(random2,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickRandom[i]);
        }

        System.out.println("Ascending");
        arr2 = random2;
        Quick.sort(arr2);

        for(int i=0;i<3; i++){
            quickAscend[i] = timer(arr2,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickAscend[i]);
        }

        System.out.println("Descending");
        descend(arr2);

        for(int i=0;i<3; i++){
            quickDescend[i] = timer(arr2,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //-------------------------------------------------------------------- 

        System.out.println("\nSort option: NoSort");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            noSortRandom[i] = timer(random2,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortRandom[i]);
        }

        System.out.println("Ascending");
        arr2 = random2;
        Quick.sort(arr2);

        for(int i=0;i<3; i++){
            noSortAscend[i] = timer(arr2,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortAscend[i]);
        }

        System.out.println("Descending");
        descend(arr2);

        for(int i=0;i<3; i++){
            noSortDescend[i] = timer(arr2,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortDescend[i]);
        }


        //---------------------------------------------------------------
        //  THIS IS THE PART WHERE WE TEST THE ARRAYS FOR THE SIZE:4000
        //  FOR THIS WE WILL USE "random3" ARRAY
        //---------------------------------------------------------------       

        System.out.println("\nInput size: 4000");

        System.out.println("\nSort option: Selection");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            selectionRandom[i] = timer(random3,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionRandom[i]);
        }

        System.out.println("Ascending");
        Integer[] arr3 = random3;
        Selection.sort(arr3);

        for(int i=0;i<3; i++){
            selectionAscend[i] = timer(arr3,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr3);

        for(int i=0;i<3; i++){
            selectionDescend[i] = timer(arr3,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------         

        System.out.println("\nSort option: Insertion");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            insertionRandom[i] = timer(random3,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionRandom[i]);
        }

        System.out.println("Ascending");
        arr3 = random3;
        Insertion.sort(arr3);

        for(int i=0;i<3; i++){
            insertionAscend[i] = timer(arr3,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr3);

        for(int i=0;i<3; i++){
            insertionDescend[i] = timer(arr3,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------         

        System.out.println("\nSort option: Merge");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            mergeRandom[i] = timer(random3,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeRandom[i]);
        }

        System.out.println("Ascending");
        arr3 = random3;
        Merge.sort(arr3);

        for(int i=0;i<3; i++){
            mergeAscend[i] = timer(arr3,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeAscend[i]);
        }

        System.out.println("Descending");
        descend(arr3);

        for(int i=0;i<3; i++){
            mergeDescend[i] = timer(arr3,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //-------------------------------------------------------------------- 

        System.out.println("\nSort option: Quick");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            quickRandom[i] = timer(random3,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickRandom[i]);
        }

        System.out.println("Ascending");
        arr3 = random3;
        Quick.sort(arr3);

        for(int i=0;i<3; i++){
            quickAscend[i] = timer(arr3,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickAscend[i]);
        }

        System.out.println("Descending");
        descend(arr3);

        for(int i=0;i<3; i++){
            quickDescend[i] = timer(arr3,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //-------------------------------------------------------------------- 

        System.out.println("\nSort option: NoSort");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            noSortRandom[i] = timer(random3,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortRandom[i]);
        }

        System.out.println("Ascending");
        arr3 = random3;
        Quick.sort(arr3);

        for(int i=0;i<3; i++){
            noSortAscend[i] = timer(arr3,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortAscend[i]);
        }

        System.out.println("Descending");
        descend(arr3);

        for(int i=0;i<3; i++){
            noSortDescend[i] = timer(arr3,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortDescend[i]);
        }


        //----------------------------------------------------------------
        //  THIS IS THE PART WHERE WE TEST THE ARRAYS FOR THE SIZE:16000
        //  FOR THIS WE WILL USE "random4" ARRAY
        //----------------------------------------------------------------         

        System.out.println("\nInput size: 16000");

        System.out.println("\nSort option: Selection");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            selectionRandom[i] = timer(random4,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionRandom[i]);
        }

        System.out.println("Ascending");
        Integer[] arr4 = random4;
        Selection.sort(arr4);

        for(int i=0;i<3; i++){
            selectionAscend[i] = timer(arr4,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr4);

        for(int i=0;i<3; i++){
            selectionDescend[i] = timer(arr4,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------        

        System.out.println("\nSort option: Insertion");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            insertionRandom[i] = timer(random4,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionRandom[i]);
        }

        System.out.println("Ascending");
        arr4 = random4;
        Insertion.sort(arr4);

        for(int i=0;i<3; i++){
            insertionAscend[i] = timer(arr4,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr4);

        for(int i=0;i<3; i++){
            insertionDescend[i] = timer(arr4,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------        

        System.out.println("\nSort option: Merge");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            mergeRandom[i] = timer(random4,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeRandom[i]);
        }

        System.out.println("Ascending");
        arr4 = random4;
        Merge.sort(arr4);

        for(int i=0;i<3; i++){
            mergeAscend[i] = timer(arr4,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeAscend[i]);
        }

        System.out.println("Descending");
        descend(arr4);

        for(int i=0;i<3; i++){
            mergeDescend[i] = timer(arr4,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------

        System.out.println("\nSort option: Quick");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            quickRandom[i] = timer(random4,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickRandom[i]);
        }

        System.out.println("Ascending");
        arr4 = random4;
        Quick.sort(arr4);

        for(int i=0;i<3; i++){
            quickAscend[i] = timer(arr4,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickAscend[i]);
        }

        System.out.println("Descending");
        descend(arr4);

        for(int i=0;i<3; i++){
            quickDescend[i] = timer(arr4,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------

        System.out.println("\nSort option: NoSort");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            noSortRandom[i] = timer(random4,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortRandom[i]);
        }

        System.out.println("Ascending");
        arr4 = random4;
        Quick.sort(arr4);

        for(int i=0;i<3; i++){
            noSortAscend[i] = timer(arr4,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortAscend[i]);
        }

        System.out.println("Descending");
        descend(arr4);

        for(int i=0;i<3; i++){
            noSortDescend[i] = timer(arr4,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortDescend[i]);
        }


        //----------------------------------------------------------------
        //  THIS IS THE PART WHERE WE TEST THE ARRAYS FOR THE SIZE:64000
        //  FOR THIS WE WILL USE "random5" ARRAY
        //----------------------------------------------------------------        

        System.out.println("\nInput size: 64000");

        System.out.println("\nSort option: Selection");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            selectionRandom[i] = timer(random5,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionRandom[i]);
        }

        System.out.println("Ascending");
        Integer[] arr5 = random5;
        Selection.sort(arr5);

        for(int i=0;i<3; i++){
            selectionAscend[i] = timer(arr5,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr5);

        for(int i=0;i<3; i++){
            selectionDescend[i] = timer(arr5,"selection");
            //System.out.println(" time in miliseconds for this step:" + selectionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------

        System.out.println("\nSort option: Insertion");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            insertionRandom[i] = timer(random5,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionRandom[i]);
        }

        System.out.println("Ascending");
        arr5 = random5;
        Insertion.sort(arr5);

        for(int i=0;i<3; i++){
            insertionAscend[i] = timer(arr5,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionAscend[i]);
        }

        System.out.println("Descending");
        descend(arr5);

        for(int i=0;i<3; i++){
            insertionDescend[i] = timer(arr5,"insertion");
            //System.out.println(" time in miliseconds for this step:" + insertionDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------        

        System.out.println("\nSort option: Merge");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            mergeRandom[i] = timer(random5,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeRandom[i]);
        }

        System.out.println("Ascending");
        arr5 = random5;
        Merge.sort(arr5);

        for(int i=0;i<3; i++){
            mergeAscend[i] = timer(arr5,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeAscend[i]);
        }

        System.out.println("Descending");
        descend(arr5);

        for(int i=0;i<3; i++){
            mergeDescend[i] = timer(arr5,"Merge");
            //System.out.println(" time in miliseconds for this step:" + mergeDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------

        System.out.println("\nSort option: Quick");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            quickRandom[i] = timer(random5,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickRandom[i]);
        }

        System.out.println("Ascending");
        arr5 = random5;
        Quick.sort(arr5);

        for(int i=0;i<3; i++){
            quickAscend[i] = timer(arr5,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickAscend[i]);
        }

        System.out.println("Descending");
        descend(arr5);

        for(int i=0;i<3; i++){
            quickDescend[i] = timer(arr5,"Quick");
            //System.out.println(" time in miliseconds for this step:" + quickDescend[i]);
        }

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------

        System.out.println("\nSort option: NoSort");
        System.out.println("Random");

        for(int i=0;i<3; i++){
            noSortRandom[i] = timer(random5,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortRandom[i]);
        }

        System.out.println("Ascending");
        arr5 = random5;
        Quick.sort(arr5);

        for(int i=0;i<3; i++){
            noSortAscend[i] = timer(arr5,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortAscend[i]);
        }

        System.out.println("Descending");
        descend(arr5);

        for(int i=0;i<3; i++){
            noSortDescend[i] = timer(arr5,"nosort");
            //System.out.println(" time in miliseconds for this step:" + noSortDescend[i]);
        }

        //-----------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------

    }



    public static Integer[] RandomArray(Random random, int size){                   //A method to create randomly generated arrays.
        Integer arr[] = new Integer[size];
        for(int i=0;i<size;i++){
            arr[i]=random.nextInt();
        }
        return arr;
    }

    public static long timer(Integer[] arr, String choice){                         //A method to measure the time and call "sortmethod" methods. 
        Integer[] temp = arr;
        long startTime = System.currentTimeMillis();
        Method.sortmethod(temp, choice);
        long stopTime = System.currentTimeMillis();
        
        return (stopTime-startTime);
    }

    public static void descend(Integer[] arr){                                      //A method to reverse the ascending sorted array to make it sorted descendingly.
        int n= arr.length;
        int temp;

        for (int i=0; i < n/2; i++){
            temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }




}
