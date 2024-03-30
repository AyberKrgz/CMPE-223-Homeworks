    //---------------------------------------------------------------
    // Title: Book.java
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 04
    // Description: A class to hold information about books.
    //----------------------------------------------------------------

public class Book {
    
    private String author;
    private String bookName;
    private int bookCount;
    private int returnDay;

    public Book(String author, String bookName, int bookCount){                 //A constructor to hold library's books author, name and count.
        this.author=author;
        this.bookName=bookName;
        this.bookCount=bookCount;

    }

    public Book(String bookName, int returnDay){                                //A constructor to hold hired books name and its return day. 
        this.bookName=bookName;
        this.returnDay=returnDay;

    }

    public String getAuthor() {return author;}

    public String getBookName() {return bookName;}

    public int getBookCount() {return bookCount;}

    public void setBookCount(int bookCount) { this.bookCount = bookCount; }

    public boolean isEmpty() {return bookCount == 0;}

    public int getReturnDay() {return returnDay;}

    public void returnBook(){                                                   //A method to increase bookCount by 1 when it's returned.
        bookCount = getBookCount()+1;
        setBookCount(bookCount);
    }

    public void hireBook(){                                                     //A method to decrease bookCount by 1 when it's hired.
        bookCount = getBookCount()-1;
        setBookCount(bookCount);
    }

    @Override
    public String toString() {                                                  //toString method to print the information as we want.
        return  author + "," + bookName + "," + bookCount;
    }

    

    
}
