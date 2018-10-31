This project was done during spring '17 at WWU



The purpose of this assignment was to manage number of books (nodes) using their pointers (front, rear)
to organize the database as well as keep track of whats coming in/out of the inventory.

BookCollection is a linked list of Book, inside a Book node is another linkedlist of BackOrderQueue.

This is a library linked list database. This database needs two component to run:


Books.txt as the inventory
Transactions.txt as the actions


Inside transactions.txt , there are two kind of actions (STOCK and ORDER). 


Every book have an SSBN number

STOCK means adding that # of books into the inventory. The number of that book to be added is at the end.
ORDER means a customer is buying that # of books. Notice at the end of every ORDER line,
there is a 6-digits number, this is the customer ID.

To run, run inventorymanager, type "java inventorymanager books.txt transactions.txt"

sampleOutput file is the correct output for checking.



THIS VERSION IS CORRECT. DO NOT CHANGE ANYTHING

