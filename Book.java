

public class Book{


   private String isbn;
   private int stock;
   private BackOrderQueue orderQ;
   public Book next;



   public Book(String isbn, int startingStock){
   	 this.isbn = isbn;
		 this.stock = startingStock;
		 this.orderQ = orderQ;
   }

	 public Book(Book next) {
		 this.next = next;
	 }




   public String getIsbn(){
   	return this.isbn;
   }


   public int getStock(){
   	return this.stock;
   }


   public BackOrderQueue getBackOrderQueue(){
   	return this.orderQ;
   }

	
   public void changeStock(int change){
   	this.stock = change;
   }


	 public void addStock(int number) {
		 this.stock += number;
	 }


   public void enterBackOrderQueue(BackOrderQueue queue) {
     this.orderQ = queue;

   }

   /*feel free to add more methods that you think are useful*/
}
