    //---------------------------------------------------------------
    // Title: Customer.java
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 04
    // Description: A class to hold information about customers.
    //----------------------------------------------------------------

public class Customer {
        private int registrationYear;
        private String customerID;
        private int startReservationDate;
        private int totalReservationDay;
        private String desiredBookName;

        //---------------------------------------------------------------------------------------------------------------------------------------------
        //  A constructor to hold customer's registration year, customer ID, start reservation date, total reservation day and desired book name.
        //---------------------------------------------------------------------------------------------------------------------------------------------

        public Customer(int registrationYear, String customerID, int startReservationDate, int totalReservationDay, String desiredBookName) {
            this.registrationYear = registrationYear;
            this.customerID = customerID;
            this.startReservationDate = startReservationDate;
            this.totalReservationDay = totalReservationDay;
            this.desiredBookName = desiredBookName;
        }

        public int getRegistrationYear() { return registrationYear; }

        public String getCustomerID() { return customerID; }

        public int getStartReservationDate() { return startReservationDate; }

        public int getTotalReservationDay() { return totalReservationDay; }

        public String getDesiredBookName() { return desiredBookName; }

        //A method to return return day (Since the reservation starts from the date which he/she hired the book).
        public int getReturnDay(int day) { return (day + totalReservationDay); }    
        

    }