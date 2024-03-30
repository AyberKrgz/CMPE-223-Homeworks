    //-------------------------------------------------------------------------------------------------------------------------------
    // Title: PriorityQueue2.java
    // Author: Ayberk Karagöz
    // ID: 11476300204
    // Section: 03
    // Assignment: 04
    // Description: A modified Priority Queue to put the customers into a queue firstly by their registiration years.
    //--------------------------------------------------------------------------------------------------------------------------------

class PriorityQueue2 {
    public Customer[] heap;
    private int size;

    public PriorityQueue2(int capacity) {                                               //A constructor to create the priority queue with the parameter capacity.
        heap = new Customer[capacity];
        size = 0;
    }

    public boolean isEmpty() {return size == 0;}

    public int getSize() { return size; }

    public void offer(Customer customer) {                                              //A method to add customers into the queue.
        if (size == heap.length) {
            // Resize the heap if it's full
            Customer[] newHeap = new Customer[2 * heap.length];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }

        heap[size] = customer;
        shiftUp(size);
        size++;
    }

    public Customer poll() {                                                            //A method to remove customers from the queue.
        if (isEmpty()) {return null;}

        Customer customer = heap[0];
        heap[0] = heap[size - 1];
        heap[size-1]=null;
        size--;
        shiftDown(0);
        return customer;
    }

    private void shiftUp(int index) {                                                   //A method to make customer more prioritised in the queue when they are added.
        int parentIndex = (index-1) / 2;
        while (index > 0 && compareCustomers(heap[index], heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            shiftUp(index);
            index = parentIndex;
            parentIndex = (index-1) / 2;
            
        }
    }

    private void shiftDown(int index) {                                                 //A method to change the customer's place which will be removed from the queue.
        int leftChildIndex = 2*index + 1;
        int rightChildIndex = 2*index + 2;
        int smallestIndex = index;

        if (leftChildIndex < size && compareCustomers(heap[leftChildIndex], heap[smallestIndex]) < 0) {smallestIndex = leftChildIndex;}

        if (rightChildIndex < size && compareCustomers(heap[rightChildIndex], heap[smallestIndex]) < 0) {smallestIndex = rightChildIndex;}

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            shiftDown(smallestIndex);
        }
    }

    private void swap(int i, int j) {                                                       //A method to sawp customers' places.
        Customer temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }



    //private int compareCustomers(Customer c1, Customer c2) -------------------------------------------------------------------------------------
    //  A method to compare customers by their:
    //  1)  Registration years            
    //  2)  Start reservation dates
    //  3)  Customer IDs
    //--------------------------------------------------------------------------------------------------------------------------------------------

    private int compareCustomers(Customer c1, Customer c2) {
        
        if (c1.getRegistrationYear() != c2.getRegistrationYear()){ return Integer.compare(c1.getRegistrationYear(), c2.getRegistrationYear()); }

        else  if (c1.getStartReservationDate() != c2.getStartReservationDate()){ return Integer.compare(c1.getStartReservationDate(), c2.getStartReservationDate()); }
        
        else{ return c1.getCustomerID().compareTo(c2.getCustomerID()); }


    }

    

    public boolean includes(String id){                                 //A method to check if there is a customer in the queue with parameter ID.
        boolean includes=false;
        for(int i=0; i<getSize(); i++){

            if(heap[i].getCustomerID().equals(id)){ includes=true; }
            else{ includes=false; }
            
        }

        return includes;

    }








}
