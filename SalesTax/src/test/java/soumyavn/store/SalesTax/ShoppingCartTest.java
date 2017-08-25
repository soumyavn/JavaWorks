package soumyavn.store.SalesTax;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import soumyavn.store.SalesTax.catalog.ImportedProduct;
import soumyavn.store.SalesTax.catalog.ImportedTaxableProduct;
import soumyavn.store.SalesTax.catalog.Product;
import soumyavn.store.SalesTax.catalog.TaxableProduct;

public class ShoppingCartTest {

	@Test
	public void testGetCartTotal() {
		assertEquals(new BigDecimal("29.83"), fillBasket1().getCartTotal());
		assertEquals(new BigDecimal("65.15"), fillBasket2().getCartTotal());
		assertEquals(new BigDecimal("74.68"), fillBasket3().getCartTotal());
	}

	@Test
	public void testGetCartSalesTaxTotal() {
		assertEquals(new BigDecimal("1.50"), fillBasket1().getCartSalesTaxTotal());
		assertEquals(new BigDecimal("7.65"), fillBasket2().getCartSalesTaxTotal());
		assertEquals(new BigDecimal("6.70"), fillBasket3().getCartSalesTaxTotal());
	}

	ShoppingCart fillBasket1() {
		ArrayList<Product> cartItems = new ArrayList<Product>();
		Product product;
		product = new Product("book", new BigDecimal("12.49"));
		cartItems.add(product);
		product = new TaxableProduct("music CD", new BigDecimal("14.99"));
		cartItems.add(product);
		product = new Product("Chocolate Bar", new BigDecimal("0.85"));
		cartItems.add(product);
		ShoppingCart cart = new ShoppingCart(cartItems);
		return cart;
	}

	ShoppingCart fillBasket2() {
		Product product;
		ArrayList<Product> cartItems = new ArrayList<Product>();
		product = new ImportedProduct("imported box of chocolates", new BigDecimal("10.00"));
		cartItems.add(product);
		product = new ImportedTaxableProduct("imported bottle of perfume", new BigDecimal("47.50"));
		cartItems.add(product);
		ShoppingCart cart = new ShoppingCart(cartItems);
		return cart;
	}

	ShoppingCart fillBasket3() {
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
