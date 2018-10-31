/*
* BackOrderNode.java
* a complete class
*
*/
public class BackOrderNode {
   private int customerNumber;
   private int amountDesired;
   public BackOrderNode next;

   public BackOrderNode(int customerNum, int amount, BackOrderNode nextOrder) {
      this.customerNumber = customerNum;
      this.amountDesired = amount;
      this.next = nextOrder;
   }

   public BackOrderNode(BackOrderNode order) {
      this.customerNumber = order.getCustomer();
      this.amountDesired = order.getAmount();
      this.next = null;
   }

   public int getCustomer() {
      return this.customerNumber;
   }

   public int getAmount() {
      return this.amountDesired;
   }

   public void setAmount(int amount) {
      amountDesired = amount;
   }
}
