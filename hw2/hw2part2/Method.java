    //----------------------------------------------------------------------
    // Title: Method
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: This file has 3 methods as sortmethod, "ABS" and "ABS2".
    //              Sortmethod takes array and a string as a parameter and
    //              decides which sort it will use with using the string.
    //              "ABS" method takes a sorted array as parameter and
    //              prints the smallest pairwise absolute difference along
    //              with the corresponding pair of numbers.
    //              "ABS2" method does the same thing for unsorted arrays.
    //----------------------------------------------------------------------

public class Method {
    

    public static void sortmethod(Integer[] arr, String choice){
        if(choice.equalsIgnoreCase("insertion")){                           //if sort method is called with "insertion" choice this code will run.
            Insertion.sort(arr);
            ABS(arr);
        } 
        else if(choice.equalsIgnoreCase("quick")){                           //if sort method is called with "quick" choice this code will run.
            Quick.sort(arr);
            ABS(arr);
        } 
        else if(choice.equalsIgnoreCase("merge")){                           //if sort method is called with "merge" choice this code will run.
            Merge.sort(arr);
            ABS(arr);
        } 
        else if(choice.equalsIgnoreCase("selection")){                       //if sort method is called with "selection" choice this code will run.
            Selection.sort(arr);
            ABS(arr);
        }
        else if(choice.equalsIgnoreCase("nosort")){                           //if sort method is called with "nosort" choice this code will run.
            ABS2(arr);     
        }
        else {                                                                              //if user selects invalid choice this code will run.
            System.out.println("Invalid choice.");
            System.exit(0);
        }
    }

    //"ABS" method takes a sorted array as parameter and
    //prints the smallest pairwise absolute difference along
    //with the corresponding pair of numbers.
    //Complexity of this method is o(n) since it has one for loop.

    public static void ABS(Integer[] arr){
        int temp;                                               //temp is the temporary value for the smallest pairwise absolute difference. It will be used for comparasions. 
        int abs = Integer.MAX_VALUE;                            //int abs is the smallest pairwise absolute difference value.
        int min=arr[0], max=arr[1], sum=0;                      //min and max are the pairs which we use to obtain abs. sum is the summation of them.

        for(int i=0;i<arr.length-1;i++){

            temp = arr[i+1]-arr[i];                             //since this is a method for sorted arrays "temp" value will always be positive.
            
            if(temp<abs){
                abs=temp;
                max = arr[i+1];
                min = arr[i];
                sum=max+min;
            }
            else if (temp==abs){                                //If there are more than one pair with the smallest absolute difference, only the one whose sum is the smallest is printed.

                if(arr[i]+arr[i+1]<sum){
                    max = arr[i+1];
                    min = arr[i];
                    sum=max+min;
                }
            }

        }
        System.out.println(abs + " [" + min + " " + max + "]");

    }

    //"ABS2" method takes an unsorted array as parameter and
    //prints the smallest pairwise absolute difference along
    //with the corresponding pair of numbers.
    //complexity of this method is o(n²) since it has two for loops nested.
    
    public static void ABS2(Integer[] arr){
        long temp;                                                          /*  Variables are almost same with the ABS method. Only difference is they are not int but long in this method  */ 
        long abs = Long.MAX_VALUE;                                          /*  because as the numbers get bigger int will not be enough to work with. */
        int min=arr[0], max=arr[1], sum=0;                                  /*  Other steps are so similar with the ABS method. */
        boolean negative;                                                   //"negative" boolean to check if the result was negative.

        for(int i=0; i<arr.length-1; i++){                                  //Used 2 for loops at here as the array is unsorted.
            for(int j=i+1; j<arr.length; j++){
                negative=false;                                             //for each operation we set "negative" as false.
                temp = (long)(arr[i]-arr[j]);
                
                if(temp<0){                                                 //if "temp" value is negative we set "negative" to true after we multiply "temp" with "-1".
                    temp = temp * -1;                                       //That's what exactly absoulte value does. If the value inside it is negative, it multiplies them with "-1".
                    negative=true;
                }

                if(temp<abs){
                    abs=temp;
                    
                    if(negative){                                           //We set "min" and "max" values according to "negative" boolean.
                        max = arr[j];
                        min = arr[i];
                    }
                    else{
                        max = arr[i];
                        min = arr[j];
                    }
                    sum=max+min;
                }
                else if (temp==abs){                                        //If there are more than one pair with the smallest absolute difference, only the one whose sum is the smallest is printed.

                    if(arr[i]+arr[j]<sum){

                        if(negative){
                            max = arr[j];
                            min = arr[i];
                        }
                        else{
                            max = arr[i];
                            min = arr[j];
                        }
                        sum=max+min;

                    }
                }


                
            }

        }
        System.out.println(abs + " [" + min + " " + max + "]");

    }

}
