    //---------------------------------------------------------------
    // Title: Main
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: Driver class which reads values from txt files
    //              and puts them into arrays to sort and print them.
    //----------------------------------------------------------------

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args){ 
        
        /* Using try-catch statement to give an error message to user if the file with the given name is not found.*/
        try {

            Scanner input = new Scanner(new File("integers.txt"));
            int numOfLines = input.nextInt();

            //  creating an Integer object array with the number of our line.
            //  We used Integer object as insertion sort uses object as parameter. (intarr2 for step4.)

            Integer[] intarr = new Integer[numOfLines];  
            Integer[] intarr2 = new Integer[numOfLines];
            
            int index=0;                                                            //"int index" to keep track of our array's index.
            while(input.hasNextLine()){
                intarr[index]=input.nextInt();                                      //Putting our integers into the array.
                intarr2[index]=intarr[index];
                index++;
            }
            input.close();
            input = null;

            System.out.println("Integers are reading from the integers.txt file, the array is:");
            printarr(intarr, numOfLines);
            
            Insertion.sort(intarr);                                                 //Sorting the array.
            System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
            printarr(intarr, numOfLines);

            System.out.println("Step 1 has been completed.\n");


            Insertion.sortDescending(intarr);                                       //Sorting the array by descending order.
            System.out.println("The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");
            printarr(intarr, numOfLines);

            System.out.println("Step 2 has been completed.\n");



            Scanner input2 = new Scanner(new File("doubles.txt"));
            int numOfLines2 = input2.nextInt();

            //creating a Double object array with the number of our line. We used Double object as insertion sort uses object as parameter.
            Double[] doublearr = new Double[numOfLines2];

            index=0;                                                                //reseting our index variable to keep track of our array's index.
            while(input2.hasNextLine()){
                doublearr[index]=input2.nextDouble();                               //putting our doubles into the array.
                index++;
            }
            input2.close();
            input2 = null;


            System.out.println("Doubles are reading from the doubles.txt file, the array is:");
            printarr2(doublearr, numOfLines2);

            Insertion.sort(doublearr);                                              //Sorting the array. 
            System.out.println("The array of double values has been sorted in increasing order by using the insertion sort algorithm:");
            printarr2(doublearr, numOfLines2);

            System.out.println("Step 3 has been completed.\n");



            System.out.println("The original array is:");
            printarr(intarr2, numOfLines);

            Merge.sortDescending(intarr2);
            System.out.println("The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
            printarr(intarr2, numOfLines);

            System.out.println("Step 4 has been completed.\n");



            Scanner input3 = new Scanner(new File("student.txt"));

            Student[] studarr = new Student[10];                                    //creating an object array for students.

            String line,name;
            int semesterNo;
            long id;

            for(int i=0;i<10;i++){                                                  //for loop to put students into the array.
                line=input3.nextLine();
                String[] st = line.split(",");                                  //using .split() method to seperate student names, id's and semesterNo's.
                
                name = st[0];
                id = Long.parseLong(st[1]);
                semesterNo = Integer.parseInt(st[2]);
                
                Student student1 = new Student(name, id, semesterNo);
                studarr[i]=student1;
            }

            Quick.sort(studarr);
            printarr3(studarr);

            System.out.println("Step 6 has been completed.\n");

            Quick.sortDescending(studarr);
            printarr3(studarr);

            System.out.println("Step 7 has been completed.\n");




        } catch (FileNotFoundException e) {
            System.out.println("There is no file found with that name. Please try again later.");       //if file has not found this message will be printed.
            throw new RuntimeException(e);
        }
    }



    public static void printarr(Integer[] arr, int numOfLines){                                         //a method to sort the integer array.
        for(int i=0; i<numOfLines; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printarr2(Double[] arr, int numOfLines){                                         //a method to sort the double array.
        for(int i=0; i<numOfLines; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printarr3(Student[] arr){                                                        //a method to sort the double array.
        for(int i=0; i<10; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

}
