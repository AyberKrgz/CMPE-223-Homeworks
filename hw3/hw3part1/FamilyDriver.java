    //---------------------------------------------------------------
    // Title: FamilyDriver
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 3
    // Description: Driver class for "FamilyTree.java". It takes a
    //              txt file input from user to create a tree and 
    //              does some operations relevant to it.
    //----------------------------------------------------------------

import java.util.Scanner;


public class FamilyDriver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter filename");
        String filename = scan.nextLine();                                                                  //Getting the filename from user. 

        FamilyTree tree = new FamilyTree();
        tree.createFamily(filename);                                                                        //Creating family tree.


        int op = 0;                                                                                         //"int op" to keep track of user's selection about operation. 

        do{
            
            System.out.println("Enter operation code:");
            op = scan.nextInt();

            if(op==1){                                                                                      //print All descendants

                System.out.println("Enter ID:");
                int id = scan.nextInt();
                tree.printAllDescendants(id);

            }

            if(op==2){                                                                                      //Check ancestor
                System.out.println("Enter IDs:");
                int id1 = scan.nextInt();
                int id2 = scan.nextInt();

                if(tree.checkAncestor(id1, id2)){ System.out.println("True"); }

                else{ System.out.println("False"); }
            }

            if(op==3){                                                                                      //Check descendant
                System.out.println("Enter IDs:");
                int id1 = scan.nextInt();
                int id2 = scan.nextInt();

                if(tree.checkDescendant(id1, id2)){ System.out.println("True"); }

                else{ System.out.println("False"); }
            }

            if(op==4){                                                                                      //Check siblings
                System.out.println("Enter IDs:");
                int id1 = scan.nextInt();
                int id2 = scan.nextInt();

                if(tree.checkSibling(id1, id2)){ System.out.println("True"); }

                else{ System.out.println("False"); }
            }

            if(op==5){                                                                                      //Find first oldest common relative
                System.out.println("Enter IDs:");
                int id1 = scan.nextInt();
                int id2 = scan.nextInt();

                System.out.println(tree.findFOCR(id1, id2));
            }

                
        }while(op != 6 );                                                                                   //Exiting the program.
        scan.close();
        System.out.println("Stopped!");
        System.exit(0);
            

            
    }


}
