package soumyavn.store.SalesTax.util;

import java.math.BigDecimal;

import soumyavn.store.SalesTax.ShoppingCart;
import soumyavn.store.SalesTax.catalog.Product;


public class Util {
	public static BigDecimal RoundToFiveCents(BigDecimal dec) {

		BigDecimal rndDecMul20 = dec.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_CEILING);
		BigDecimal rndDec = rndDecMul20.divide(new BigDecimal("20")).setScale(2, BigDecimal.ROUND_CEILING);
		return rndDec;

	}

	public static void displayGuide() {
		System.out.println();
		System.out.println("These 3 ShoppingCarts are in line. Please choose one to checkout...");
		System.out.println();
		System.out.println("SHOPPING CART 1");
		System.out.println("********************");
		System.out.println("1 book at 12.49");
		System.out.println("1 music CD at 14.99");
		System.out.println("1 chocolate bar at 0.85");
		System.out.println();

		System.out.println("SHOPPING CART 2");
		System.out.println("********************");
		System.out.println("1 imported box of chocolates at 10.00");
		System.out.println("1 imported bottle of perfume at 47.50");
		System.out.println();

		System.out.println("SHOPPING CART 3");
		System.out.println("********************");
		System.out.println("1 imported bottle of perfume at 27.99");
		System.out.println("1 bottle of perfume at 18.99");
		System.out.println("1 packet of headache pills at 9.75");
		System.out.println("1 imported box of chocolates at 11.25");
		System.out.println();

		System.out.println("PLEASE ENTER YOUR INPUT (1, 2 OR 3) :");

	}

	public static void printReceipt(ShoppingCart shoppingCart) {
		System.out.println();
		System.out.println("SALES RECEIPT");
		System.out.println("********************");
		for (Product product : shoppingCart.getItems()) {
			System.out.println("1 " + product.getName() + ": " + product.calcTotalPrice());
		}
		System.out.println("Sales Taxes: " + shoppingCart.getCartSalesTaxTotal());
		System.out.println("Total: " + shoppingCart.getCartTotal());
	}
	
}