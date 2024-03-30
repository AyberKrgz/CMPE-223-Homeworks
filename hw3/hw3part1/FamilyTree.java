    //---------------------------------------------------------------------
    // Title: FamilyTree
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 3
    // Description: This is a java class of a simple family tree system
    //              using tree data structure with some extra methods.
    //---------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class FamilyTree {

    private class Node {
        int id;                                                                                                 //int id to hold id of the person.
        String name;                                                                                            //String name to hold name of the person.
        List<Node> children;                                                                                    //We use children arraylist to connect children with parents.
    
        public Node(int id, String name) {                                                                      //Holding the id, name and children arraylist under nodes.
            this.id = id;
            this.name = name;
            this.children = new ArrayList<>();                                                                  //We use children arraylist to connect children with parents.
        }
    
        public void addChild(Node child) {
            this.children.add(child);
        }
    }

    private Node root;

    public FamilyTree() {
        this.root = null;
    }

    public void createFamily(String filename) {                                                                 //This method tries to create the family tree with using txt file provided from user.
        
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();                                                                    //Scanning the txt file line by line.
                String[] person = line.split(",");                                                          //Splitting string from "," to seperate parent and child from eachother and hold them into arrays.
                
                String[] data0 = person[0].split(" ");                                                      //Splitting array from " " to seperate id and name from eachother and hold them into arrays.
                String[] data1 = person[1].split(" ");                                                      //Splitting array from " " to seperate id and name from eachother and hold them into arrays.

                int parentId = Integer.parseInt(data0[1]);                                                          //Setting id of the parent.
                String parentName = data0[0];                                                                       //Setting name of the parent.

                int childId = Integer.parseInt(data1[1]);                                                           //Setting id of the child.
                String childName = data1[0];                                                                        //Setting name of the child.

                Node child = new Node(childId, childName);                                                          //Putting the child into the node.


                if (root == null) { root = new Node(parentId, parentName); }                                        //If root is null we set the parent as root.
                
                Node parent = findNode(root, parentId);                                                             //Setting parent node with using parentId.
                parent.addChild(child);                                                                             //Attaching child to its parent.
                
                
            }

            scan.close();
        }catch (FileNotFoundException e) {
            System.out.println("There is no file found with that name. Please try again later.");       //if file has not found this message will be printed.
            throw new RuntimeException(e);
        }
    }

    private Node findNode(Node node, int id) {                                                      //This method tries to find and return the node whose id is equal to the parameter id.

        if (node.id == id) { return node; }

        for (Node child : node.children) {
            Node foundNode = findNode(child, id);                                                   //searching every child with recursion until we find the one.

            if (foundNode != null) { return foundNode; }
        }

        return null;
    }

    private void getAllDescendants(Node node, List<Node> descendants) {                             //A method to put all descendants into a list.

        for (Node child : node.children) {
            getAllDescendants(child, descendants);                                                  //Recursive function to find all descendants.
            descendants.add(child);                                                                 //Putting every child into 'descendants' list.
        }
    }

    public void printAllDescendants(int id) {                                                       //A method to print all descendents.

        Node node = findNode(root, id);

        if (node != null) {

            List<Node> descendants = new ArrayList<>();
            getAllDescendants(node, descendants);

            String line = "";
            for (Node descendant : descendants) {
                line += descendant.name + ", ";                                                     //"line" string to hold all descendant's name.
            }

            System.out.println(line.substring(0, line.length()-2));                     //With using substring() function we get rid of the "," at the end.
        }
    }

    public boolean checkAncestor(int ancestorId, int descendantId) {                            //A method to check if the guy who's id is given first is an ancestor of the second one. 
        Node ancestor = findNode(root, ancestorId);
        Node descendant = findNode(root, descendantId);

        return isAncestor(ancestor, descendant);
    }

    private boolean isAncestor(Node ancestor, Node descendant) {                                //A method to check if the first guy is an ancestor of the second one. 

        for (Node child : ancestor.children) {
            if (isAncestor(child, descendant)) {                                                //Using a recursive function with ancestor's every child and their children to check if our ancestor is the ancestor of the descendant. 
                return true;
            }
        }

        if (ancestor == descendant) {                                                           //If they are equal, then we must finally found him by searching through his ancestor's children.
            return true;
        }

        if (ancestor == null || descendant == null) {                                           //If they are null it means there is no child to look at. So the argument is wrong.
            return false;
        }        

        return false;
    }

    public boolean checkDescendant(int descendantId, int ancestorId) {                          //A method to check if the 1st guy is a descendant of the 2nd guy.
        return checkAncestor(ancestorId, descendantId);                                         //We can reuse the checkAncestor function here since if the 2nd one is the ancestor of the 1st one, then the 1st one is the ancestor of the 2nd one.
    }

    public boolean checkSibling(int id1, int id2) {                                             //A method to check if the given two is siblings.

        Node node1 = findNode(root, id1);
        Node node2 = findNode(root, id2);

        Node parent1 = getParent(root, node1);                                                  //Finding the parent of the first one.
        Node parent2 = getParent(root, node2);                                                  //Finding the parent of the second one.

        if(parent1 == parent2){ return true; }                                                  //Checking if they are equal.
        else{ return false; }

    }

    private Node getParent(Node current, Node node) {                                           //A method to find the parent of the second parameter node.

        for(Node child : current.children){

            if(child == node){ return current; }                                            //If current's child is equals to the node whose parents are searched, then current node is the parent.

            else{
                Node parent = getParent(child, node);                                       //Using recursive function to search every child.

                if(parent != null){ return parent; }                                      //If it's found after this recursive function it must be returned.
            }

        }

        return null;                                                                        //If not found return null.
    }




    private Node FOCR(Node node1, Node node2){                                          //A method to find First Oldest Common Relative.

        Node parent1 = getParent(root, node1);
        Node parent2 = getParent(root, node2);

        if(parent1==parent2){ return parent1; }                                         //If their parents are the same it must be returned.

        else if(parent1==node2){ return parent2; }                                      //If first guys parent is the second guy, then second guys parent must be returned.
        
        else if(parent2==node1){ return parent1; }                                      //If second guys parent is the first guy, then first guys parent must be returned.

        else{

            Node parent = FOCR(parent1, node2);                                         //Recursion with first guy's parent and the second guy
            if(parent != null){ return parent; }

            parent = FOCR(node1, parent2);                                              //Recursion with second guy's parent and the first guy
            if(parent != null){ return parent; }


            return root;                                                                //If all of them fails then the root must be returned.

        }

    }

    public String findFOCR(int id1, int id2){                                           //A method to find First Oldest Common Relative by their ID's.

        Node node1 = findNode(root, id1);
        Node node2 = findNode(root, id2);

        Node commonAncestor = FOCR(node1, node2);

        return commonAncestor.name;                                                     //It returns First Oldest Common Relative's name.

    }


}