    //--------------------------------------------------------------------
    // Title: Student
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 2
    // Description: A comparable object which has 3 variables as name,
    //              id and semesterNo. It has compareTo method to 
    //              compare students by their variables. toString method
    //              helps us to print the objects as we wanted.
    //--------------------------------------------------------------------

public class Student implements Comparable<Student>{
    
    public String name;
    long id;
    int semesterNo;

    public Student(String name, long id, int semesterNo){
        this.name=name;
        this.id=id;
        this.semesterNo=semesterNo;
    }

    public int compareTo(Student s){
        if(this.id < s.id) { return -1; }
        if(this.id > s.id) { return +1; }
        if(this.semesterNo < s.semesterNo) { return -1; }
        if(this.semesterNo > s.semesterNo) { return +1; }
        if(this.name.compareTo(s.name) < 0) { return -1; }
        if(this.name.compareTo(s.name) > 0) { return +1; }
        return 0;
    }

    @Override
    public String toString() {
        return id + ": " + name + " " + semesterNo;
    }



}
