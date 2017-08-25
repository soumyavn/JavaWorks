
SalesTax Application
*********************

INPUT FORMAT
---------------
	3 Shopping carts are predefined. An input of 1, 2 or 3 is required to checkout.

OUTPUT 
-------
	Receipt lists names of all the items and their prices (including tax), finishing with 
	the total cost of the items and the total amounts of sales taxes paid. Basic sales tax is 
	applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. 
	Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
	Sales taxes are rounded UP to the nearest 0.05. 

E.g:

Sample Input:

	These 3 ShoppingCarts are in line. Please choose one to checkout...
	
	SHOPPING CART 1
	********************
	1 book at 12.49
	1 music CD at 14.99
	1 chocolate bar at 0.85

	SHOPPING CART 2
	********************
	1 imported box of chocolates at 10.00
	1 imported bottle of perfume at 47.50

	SHOPPING CART 3
	********************
	1 imported bottle of perfume at 27.99
	1 bottle of perfume at 18.99
	1 packet of headache pills at 9.75
	1 imported box of chocolates at 11.25

	PLEASE ENTER YOUR INPUT (1, 2 OR 3) :
	1

Output:

	SALES RECEIPT
	********************
	1 imported bottle of perfume : 32.19
	1 bottle of perfume: 20.89
	1 packet of headache pills: 9.75
	1 imported box of chocolates: 11.85
	Sales Taxes: 6.70
	Total: 74.68

Note:
	Environment: Java 7
	Main Method Class: /SalesTax/src/main/java/soumyavn/store/SalesTax/CheckOut.java

