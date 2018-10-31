/*
* InventoryManager.java
* a complete class
*
*/

public class InventoryManager {   
   public static void main(String[] args) {
      BookCollection collection;
      if(args.length != 2){
         System.out.println("Please Enter 2 Line Arguments!"); 
         return; /* terminate the program */
      }
      collection = new BookCollection(args[0]); //initiate the book inventory with the first input file 
      collection.processTransactions(args[1]); //process transactions in the second input file
   }
}
