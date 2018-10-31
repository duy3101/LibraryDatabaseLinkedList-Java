


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class BookCollection {



   private Book first;
   private Book last;


   public BookCollection (String bookFile) {
      getBooks(bookFile);
   }


   private void getBooks(String bookFile) {

     Scanner input = null;
     try {
       input = new Scanner(new File(bookFile));
     }
     catch  (FileNotFoundException e) {
       System.out.println("Error occured");
     }

     while (input.hasNextLine()) {
       String line = input.nextLine();
       Scanner readLine = new Scanner(line);
       String isbn = readLine.next();
       int stock = readLine.nextInt();
       Book current = new Book(isbn, stock);
           if (first == null) {
             first = current;
             last = current;
           }
           else {
             last.next = current;
             last = last.next;
           }
         }
   }



   private Book findBook(String isbn){
     Book current = first;

     while(current != null) {
       String compareISBN = current.getIsbn();
       if (compareISBN.equals(isbn)) {
         return current;
       }
       current = current.next;
     }
     return current;
   }


   public void addBook(Book book){
     last.next = book;
     last = book;

   }


   public void processTransactions(String transactionsFile) {


     Scanner input = null;
     try {
       input = new Scanner(new File(transactionsFile));
     }
     catch  (FileNotFoundException e) {
       System.out.println("Error occured");
     }

     while (input.hasNextLine()) {
       String line = input.nextLine();
       Scanner readLine = new Scanner(line);
       String typeORDER = readLine.next();


       if (typeORDER.equals("STOCK")) {


         String fileISBN = readLine.next();
         int fileStock = readLine.nextInt();
         Book current = findBook(fileISBN);
         if (current == null) {
           Book newBook = new Book(fileISBN, 0);
           addBook(newBook);
         }
         System.out.println("Stock for " + fileISBN + " increased from " + current.getStock() + " to " + (current.getStock() + fileStock));
         current.addStock(fileStock);

         BackOrderQueue currentQueue = current.getBackOrderQueue();
         if (currentQueue != null) {

           while(current.getStock() != 0 && currentQueue.size() != 0) {

             BackOrderNode currentNode = currentQueue.front();
             int customerID = currentNode.getCustomer();
             int desiredAmount = currentNode.getAmount();

             if (current.getStock() >= desiredAmount) {
               int remainingStock = current.getStock() - desiredAmount;
               System.out.println("Order filled for customer " + customerID + " for " + (current.getStock() - remainingStock) + " of book " + fileISBN);
               current.changeStock(remainingStock);
               currentQueue.dequeue();
             }
             else if (current.getStock() < desiredAmount) {
               int newAmount = desiredAmount - current.getStock();
               currentNode.setAmount(newAmount);
               current.changeStock(0);
               System.out.println("Order filled for customer " + customerID + " for " + (desiredAmount - newAmount) + " of book " + fileISBN);
               System.out.println("Back order of " + currentNode.getAmount() + " copy/copies of book " + fileISBN + " for customer " + customerID);
             }
          }
        }
      }





         else if (typeORDER.equals("ORDER")) {


           String fileISBN = readLine.next();
           int fileDesire = readLine.nextInt();
           int fileID = readLine.nextInt();
           Book current = findBook(fileISBN);
           if (current == null) {
             Book newBook = new Book(fileISBN, 0);
             addBook(newBook);
             System.out.println("Back order of " + fileDesire + " copy/copies of book " + fileISBN + " for customer " + fileID);
           }


           else {

             int currentStock = current.getStock();
             if (currentStock >= fileDesire) {
               int remainingStock = currentStock - fileDesire;
               System.out.println("Order filled for customer " + fileID + " for " + fileDesire + " of book " + fileISBN);
               fileDesire = (currentStock - remainingStock) - fileDesire;
               current.changeStock(remainingStock);
             }

             else if (currentStock < fileDesire) {

               BackOrderQueue currentQueue = current.getBackOrderQueue();
               if (currentQueue == null) {
                 currentQueue = new BackOrderQueue();

               }
               int fileDesire2 = 0;
               if (currentStock > 0) {
                 fileDesire2 = fileDesire - currentStock;
                 System.out.println("Order filled for customer " + fileID + " for " + (fileDesire - fileDesire2) + " of book " + fileISBN);
                 current.changeStock(0);
                 currentQueue.enqueue(fileID, fileDesire2);
                 current.enterBackOrderQueue(currentQueue);
                 System.out.println("Back order of " + fileDesire2 + " copy/copies of book " + fileISBN + " for customer " + fileID);

               }

               if (currentStock == 0 && fileDesire > 0) {
                 currentQueue.enqueue(fileID, fileDesire);
                 current.enterBackOrderQueue(currentQueue);
                 System.out.println("Back order of " + fileDesire + " copy/copies of book " + fileISBN + " for customer " + fileID);

              }
            }
          }
        }
    }
  }
}
