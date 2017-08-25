package soumyavn.store.SalesTax;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import soumyavn.store.SalesTax.catalog.ImportedProduct;
import soumyavn.store.SalesTax.catalog.ImportedTaxableProduct;
import soumyavn.store.SalesTax.catalog.Product;
import soumyavn.store.SalesTax.catalog.TaxableProduct;
import soumyavn.store.SalesTax.util.Util;

public class CheckOut {

	public static void main(String[] args) {

		int input = 0;
		ShoppingCart shoppingCart;
		Util.displayGuide();
		try {
			input = System.in.read();
		} catch (IOException e) {
			System.out.println("Error Occured");
		}

		switch ((char) input) {
		case '1':
			shoppingCart = fillBasket1();
			doCheckout(shoppingCart);
			break;
		case '2':
			shoppingCart = fillBasket2();
			doCheckout(shoppingCart);
			break;
		case '3':
			shoppingCart = fillBasket3();
			doCheckout(shoppingCart);
			break;
		default:
			System.out.println("Invalid input. Please try again!");

		}

	}

	public static void doCheckout(ShoppingCart shoppingCart) {

		Util.printReceipt(shoppingCart);
	}

	static ShoppingCart fillBasket1() {
		ArrayList<Product> cartItems = new ArrayList<Product>();
		Product product;
		product = new Product("book", new BigDecimal("12.49"));
		cartItems.add(product);
		product = new TaxableProduct("music CD", new BigDecimal("14.99"));
		cartItems.add(product);
		product = new Product("chocolate Bar", new BigDecimal("0.85"));
		cartItems.add(product);
		ShoppingCart cart = new ShoppingCart(cartItems);
		return cart;
	}

	static ShoppingCart fillBasket2() {
		Product product;
		ArrayList<Product> cartItems = new ArrayList<Product>();
		product = new ImportedProduct("imported box of chocolates", new BigDecimal("10.00"));
		cartItems.add(product);
		product = new ImportedTaxableProduct("imported bottle of perfume", new BigDecimal("47.50"));
		cartItems.add(product);
		ShoppingCart cart = new ShoppingCart(cartItems);
		return cart;
	}

	static ShoppingCart fillBasket3() {
		Product product;
		ArrayList<Product> cartItems = new ArrayList<Product>();
		product = new ImportedTaxableProduct("imported bottle of perfume ", new BigDecimal("27.99"));
		cartItems.add(product);
		product = new TaxableProduct("bottle of perfume", new BigDecimal("18.99"));
		cartItems.add(product);
		product = new Product("packet of headache pills", new BigDecimal("9.75"));
		cartItems.add(product);
		product = new ImportedProduct("imported box of chocolates", new BigDecimal("11.25"));
		cartItems.add(product);
		ShoppingCart cart = new ShoppingCart(cartItems);
		return cart;
	}

}
