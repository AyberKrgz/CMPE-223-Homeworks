    //-------------------------------------------------------------
    // Title: BST
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 3
    // Description: This is a modified Binary Search Tree class
    //              for a company's employee database.
    //-------------------------------------------------------------

public class BST {

    private Node root;

    public BST() {
        root = null;
    }

    private class Node{

        int id;                                                                                         //"int id" to hold id of the person.
        String name;                                                                                    //"String name" to hold name of the person.
        boolean gender;                                                                                 //"boolean gender" to hold the gender of the person. (0 represents male, 1 represents female)

        private Node left, right;

        public Node(int id, String name, Boolean gender){                                               //Holding the id, name and gender under nodes.
            this.id=id;
            this.name=name;
            this.gender=gender;
            this.left= this.right = null;
        }
    }
    
    public void add(int id, String name, boolean gender){                                               //A method to add the person with given parameters into our Binary Search Tree.
        root = add(root, id, name, gender);
    }

    public Node add(Node x, int id, String name, boolean gender){                                       //A method to add the person with given parameters into our Binary Search Tree.

        if (x == null){                                                                                 //If the selected node (x) is null, then we set the new node at that.
            x = new Node(id, name, gender);
        }
        else{    
            if(id < x.id){ x.left = add(x.left, id, name, gender); }                                    //If the new guy's id is smaller than the selected (x) node's id, then we should go to x's left with the help of recursion. 

            else if(id > x.id){ x.right = add(x.right, id, name, gender); }                             //If the new guy's id is greater than the selected (x) node's id, then we should go to x's right with the help of recursion. 

            else{                                                                                       //If the new guy's id is equal to the selected (x) node's id, then new guy's information will be set to x.
                x.name = name;
                x.id = id;
                x.gender = gender;
            }
        }
        return x;
    }

    public void search(int id){                                                                         //A method to search an employee by their ID.
        root = search(root, id);
    }

    public Node search(Node x, int id){                                                                 //A method to search an employee by their ID.
        if(x == null){ System.out.println("No record found."); }                                      //If not found, this message will be printed.

        else{
            if(id < x.id){ x.left = search(x.left, id); }                                               //If the id we search is smaller than the selected (x) node's id, then we should check it's left with the help of recursion.

            else if(id > x.id){ x.right = search(x.right, id); }                                        //If the id we search is greater than the selected (x) node's id, then we should check it's right with the help of recursion.

            else{ printNode(x); }                                                                       //If the id we search is equal to the selected (x) node's id, then this employee's information must be printed.

        }
        return x;


    }

    public void listAll(){                                                                              //A method to print all information in ascending order based on ID.
        root = list(root);
    }
    
    public Node list(Node x){                                                                           //A method to print all information in ascending order based on ID.

        if(x != null){                                                                                  //With a recursive function, we go to the most left and then print
            x.left = list(x.left);                                                                      //its informations since tree is filled from left in ascending order based on ID.
            printNode(x);                                                                               //So, the print order is: Left childs, parents, right childs.
            x.right = list(x.right);
        }

        return x;
    }



    boolean found = false;                                                                              //"boolean found" to check if we could find any guy in the given range. This boolean will be used in the next two methods.

    
    public void listRange(int num1, int num2){                                                          //A method to print all employees information which have ID within the specified range in ascending order based on ID.
        found = false;                                                                                  //Set to false at every use.
        root = listRange(root, num1, num2);
        if(found == false){ System.out.println("No record found."); }                                 //If we can't find any guy in the given range this message will be printed.
    }
    

    public Node listRange(Node x, int num1, int num2){                                                  //A method to print all employees information which have ID within the specified range in ascending order based on ID.
        
        if(x != null){

            if(num1 > x.id){ x.right = listRange(x.right, num1, num2); }                                //If the selected (x) node's id is smaller then the lower boundary, then we might want to check x's right with the help of recursion.
            if(num2 < x.id){ x.left = listRange(x.left, num1, num2); }                                  //If the selected (x) node's id is greater then the upper boundary, then we might want to check x's left with the help of recursion.

            if(num1 <= x.id && x.id <= num2){                                                           //The case when the selected (x) node's id is in the range of boundaries
                x.left = listRange(x.left, num1, num2);                                                 //Checking the left child.
                printNode(x);                                                                           //Printing selected node's informations.
                x.right = listRange(x.right, num1, num2);                                               //Checking the right child.
                found = true;                                                                           //We set "found" to true since atleast one guy's id is in the range and it will be printed.
            }

        }


        return x;
    }

    public void printNode(Node x){                                                                      //A method to print employee's informations.
        String gender2;                                                                                 //"String gender2" to easily print the gender as we wanted.
        if(x.gender){ gender2 = "Female"; }                                                             //If selected (x) node's "gender" is set to "true", then she is a female. So, we set its "gender2" to "Female".
        else{ gender2 = "Male"; }                                                                       //If selected (x) node's "gender" is set to "false", then he is a male. So, we set its "gender2" to "Male".
        System.out.println(x.id + " " + x.name + " " + gender2);                                        //Printing the employee's informations.
    }


    public void delete(int id){                                                                         //A method to delete an employee with using their ID to find them.
        root = delete(root, id);
    }

    public Node delete(Node x, int id){                                                                 //A method to delete an employee with using their ID to find them.

        if(x == null){                                                                                  //If there is no employee with the given ID this message will be printed.
            System.out.println("No record found.");
            return null;
        }
        else{
            if(id < x.id){ x.left = delete(x.left, id); }                                               //If the id we search is smaller than the selected (x) node's id, then we should check it's left with the help of recursion.
            else if(id > x.id){ x.right = delete(x.right, id); }                                        //If the id we search is greater than the selected (x) node's id, then we should check it's right with the help of recursion.

            else{                                                                                       //The case where we found the employee
                if(x.left == null && x.right == null){ x = null; }                                      //If the node has no children, node will be deleted directly.
                else if(x.left == null){ return x.right; }                                              //If the node has only right children, right children will be replaced with its parent.
                else if(x.right == null){ return x.left; }                                              //If the node has only left children, left children will be replaced with its parent.
                else{                                                                                   //The case where the node has both left and right children

                    Node temp = x;                                                                      //Creating a temporary node and setting x (the node that we want to delete) to it.

                    x = min(temp.right);                                                                //We are setting x to the smallest node which is greater than x.
                    x.right = deleteMin(temp.right);                                                    //Deleting it's old node.
                    x.left = temp.left;                                                                 //Connecting the left child to its new parent(min).
                    
                }

            }

        }
        return x;

    }

    public Node min(Node x){                                                                            //A recursive function to find the minimum child of the selected node (x).
        if(x == null){ return null; }                                                                   //If x is null, then we must return null.
        else if(x.left == null){ return x; }                                                            //If the selected (x) node has no left child, then it's the smallest that we search. So, x should be returned.
        else{ return min(x.left); }                                                                     //If the selected (x) node still has left child, then we put that child into our function again.(recursion)
    }


    public void deleteMin(){                                                                            
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null){ return x.right; }
        x.left = deleteMin(x.left);
        return x;
    }



}