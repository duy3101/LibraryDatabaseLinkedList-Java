

public class BackOrderQueue {
   private BackOrderNode front;
   private BackOrderNode rear;


   public BackOrderQueue() {
     front = null;
     rear = null;
   }


   public boolean isEmpty() {
     return front == null;
   }


   public void enqueue(int customer, int stock) {
     if (isEmpty()) {
       rear = new BackOrderNode(customer, stock, null);
       front = rear;
     }
     else {
       rear.next = new BackOrderNode(customer, stock, null);
       rear = rear.next;
     }
   }


   public void dequeue() {
     if (isEmpty()) {
       throw new RuntimeException("Queue underflow");
     }
     else {
       front = front.next;
       if (front == null) {
         rear = null;

       }
     }

   }


   public BackOrderNode front() {
     if (isEmpty()) {
       throw new RuntimeException("Queue underflow");

     }
     return front;
   }


   public int size() {
     BackOrderNode current = front;
     int length = 0;
     while (current != null) {
       length++;
       current = current.next;

     }
     return length;
   }



}
