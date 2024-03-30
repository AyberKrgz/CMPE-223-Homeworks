    //------------------------------------------------------------------------
    // Title: Driver.java
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 04
    // Description: The driver class of the program to manage the library.
    //------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Driver {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileName;
        System.out.println("Enter log file name:");
        fileName = scan.nextLine();                                                             //Getting the filename to scan the file.
        scan.close();

        ArrayList<Integer> dayList = new ArrayList<>();                                         //An ArrayList to hold the days given in the txt file.
        ArrayList<Book> bookList = new ArrayList<>();                                           //An ArrayList to hold the books given in the txt file.
        ArrayList<Book> givenBooks = new ArrayList<>();                                         //An ArrayList to hold the hired books.

        Book givenbook;                                                                         //Creating a Book object to hold informations about the hired books.
        PriorityQueue queue = new PriorityQueue(200);                                  //Creating the Priority queue with 200 capacity to hold customers.
        PriorityQueue2 waitingCustomers = new PriorityQueue2(200);                     //Creating the Priority queue with 200 capacity to hold waiting customers.
        
        try{
            File file = new File(fileName);
            Scanner input = new Scanner(file);                                                  //Scanning the file.

            String line;
            
            

            while(input.hasNextLine()){

                input.nextLine();                   //Skipping the header.


                //Scans the lines starting from "***BOOK INFO**" to "**DAY INFO**".
                //Gets books' informations and adds them into bookList ArrayList.

                while(!((line = input.nextLine()).equals("**DAY INFO**"))){
                    String[] book = line.split(",");

                    String author = book[0];
                    String bookName = book[1];
                    int bookCount = Integer.parseInt(book[2]);

                    Book newBook = new Book(author, bookName, bookCount);
                    
                    bookList.add(newBook);

                }


                //Scans the lines starting from "**DAY INFO**" to "***CUSTOMER INFO***".
                //Adds days to the dayList ArrayList.

                while(!((line = input.nextLine()).equals("***CUSTOMER INFO***"))){
                    
                    int day = Integer.parseInt(line);
                    dayList.add(day);
                }
                
                

                //Scans the lines starting from "***CUSTOMER INFO***" to end.
                //Gets customers' informations and adds them into Priority Queue.

                while(!((line = input.nextLine()).isEmpty())){
                    String[] customer = line.split(",");

                    int registrationYear = Integer.parseInt(customer[0]);
                    String customerID = customer[1];
                    int startReservationDate = Integer.parseInt(customer[2]);
                    int totalReservationDay = Integer.parseInt(customer[3]);
                    String desiredBookName = customer[4];

                    Customer newCustomer = new Customer(registrationYear, customerID, startReservationDate, totalReservationDay, desiredBookName);

                    queue.offer(newCustomer);
  

                }


            }
            input.close();


                //-------------------------------------------
                //  GOING TROUGH ALL DAYS
                //-------------------------------------------

            for(int day=0; day<=30; day++){
                
                               
                //-------------------------------------------
                //  PRINTING THE RESULTS
                //-------------------------------------------

                for(int a=0; a < dayList.size();a++){

                    if(day == dayList.get(a)){                              //If the current day is provided in the txt file the results of this day will be printed.
                        System.out.println("Day " + day + ":");


                        System.out.println("Customer info:");

                        if(waitingCustomers.isEmpty()){ System.out.println("No waiting customer"); }

                        else{

                            for(int m=0; m < waitingCustomers.getSize(); m++){

                                if(day >= waitingCustomers.heap[m].getStartReservationDate()){
                                    System.out.println(waitingCustomers.heap[m].getCustomerID() + " waits " + waitingCustomers.heap[m].getDesiredBookName() + " since day " + waitingCustomers.heap[m].getStartReservationDate() + ".");
                                }
                            }

                        }


                        System.out.println("Book info:");
                        for(int j=0; j<bookList.size(); j++){
                            System.out.println(bookList.get(j));
                        }
                    }
                }
                

                //-------------------------------------------
                //  CUSTOMERS RETURNING THEIR BOOKS
                //-------------------------------------------

                
                for(int i=0; i<givenBooks.size(); i++){

                    if(!givenBooks.isEmpty()){

                        if( day >= givenBooks.get(i).getReturnDay() ){

                            for (int j=0; j<bookList.size(); j++){
                                    
                                if(givenBooks.get(i).getBookName().equals(bookList.get(j).getBookName())){ 
                                    bookList.get(j).returnBook();                                                   //Increasing the count of the reletad book.
                                    givenBooks.remove(i);                                                           //Removing the returned book from the givenBooks ArrayList.
                                    break;
                                }
                            }
                            
                            i--;

                        }

                    }

                }


                //-------------------------------------------
                //  CUSTOMERS GETTING THEIR BOOKS
                //-------------------------------------------
                

                for(int i=0; i<bookList.size(); i++){
                
                    int j=0;
                    while(j < queue.getSize()){
                        
                        
                        //If we have the book that customer wants (after that day)
                        if( (queue.heap[j].getDesiredBookName()).equals(bookList.get(i).getBookName()) && queue.heap[j].getStartReservationDate() <= day){

                            if( bookList.get(i).getBookCount() > 0 ){
                                givenbook = new Book(bookList.get(i).getBookName(), queue.heap[j].getReturnDay(day));               //Holding the name and the return day of the book under givenbook object
                                givenBooks.add(givenbook);                                                                          //Adding the given book to givenBooks ArrayList.

                                queue.poll();                                                                                       //Removing the customer from the queue.
                                bookList.get(i).hireBook();                                                                         //Decreasing the book's count.

                                for(int a=0; a<waitingCustomers.getSize(); a++){

                                    if( !(queue.includes(waitingCustomers.heap[a].getCustomerID())) ){

                                        waitingCustomers.poll();                                            //If a customer from waitingCustomers queue gets the book they want we should remove them from this queue as well.
                                    }

                                }

                                                            
                                j--;
                            }
                            
                            //Else if we don't have that book at the day we are adding the customer to a new queue which is "waitingCustomers".
                            else{

                                if(waitingCustomers.isEmpty()){ waitingCustomers.offer(queue.heap[j]); }

                                else{

                                    if( !(waitingCustomers.includes(queue.heap[j].getCustomerID())) ){ waitingCustomers.offer(queue.heap[j]); }
                                }
 
                            }

                        }                        

                        j++;


                    }

                }

            }


        }catch (FileNotFoundException e) {
            System.out.println("There is no file found with that name. Please try again later.");       //if file has not found this message will be printed.
            throw new RuntimeException(e);
        }


    }


}
