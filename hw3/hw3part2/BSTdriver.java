    //----------------------------------------------------------------------
    // Title: BSTdriver
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 3
    // Description: Driver class for "BST.java". It does some opearations 
    //              based on user's choices.
    //----------------------------------------------------------------------

import java.util.Scanner;

public class BSTdriver {
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int id;                                                                             //"int id" to hold the employee IDs.
        String name, gender;                                                                //"String name" to hold employee name and "String gender" to hold employee gender.
        boolean gender2;                                                                    //"boolean gender2" to hold employee gender as "boolean" as its wanted.

        BST tree = new BST();

        int op = 0;                                                                         //"int op" to keep track of user's selection about operation. 
        do{
            System.out.println("Enter operation code:");
            op = scan.nextInt();

            if(op==1){                                                                      //Insert an employee
                System.out.println("Enter information:");
                id = scan.nextInt();
                name = scan.next();
                gender = scan.next();

                if(gender.equalsIgnoreCase("male")){ gender2=false; }                   //Setting "gender2" to false if the employee is male.
                else if(gender.equalsIgnoreCase("female")){ gender2=true; }             //Setting "gender2" to true if the employee is female.
                else{                                                                                 //The case where user gives an input other than "male" or "female".
                    gender2=false;
                    System.out.println("MissInput!");
                    System.exit(0);
                }

                tree.add(id, name, gender2);
            }

            else if(op==2){                                                                 //Delete an employee
                System.out.println("Enter ID to be deleted:");
                id = scan.nextInt();
                tree.delete(id);
                
            }

            else if(op==3){                                                                 //Search for an employee by ID number
                System.out.println("Enter ID to be searched:");
                id = scan.nextInt();
                tree.search(id);
            }

            else if(op==4){                                                                 //List all employees in order by ID number
                tree.listAll();
            }

            else if(op==5){                                                                 //List all employees in order by ID number in given range.
                System.out.println("Enter bounds of range:");
                int num1 = scan.nextInt();
                int num2 = scan.nextInt();
                tree.listRange(num1, num2);
            }

        }while(op!=6);                                                                      //Quit
        scan.close();
        System.out.println("Stopped!");
        System.exit(0);
      
    }

}
