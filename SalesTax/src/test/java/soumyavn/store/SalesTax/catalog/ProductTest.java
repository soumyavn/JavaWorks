package soumyavn.store.SalesTax.catalog;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import soumyavn.store.SalesTax.catalog.Product;

public class ProductTest {

	Product product1 = new Product("book", new BigDecimal("12.49"));
	Product product2 = new Product("Chocolate Bar", new BigDecimal("0.85"));
	Product product3 = new Product("packet of headache pills", new BigDecimal("9.75"));

	@Test
	public void testCalcSalesTax() {
		assertEquals(new BigDecimal("0.00"), product1.calcSalesTax());
		assertEquals(new BigDecimal("0.00"), product2.calcSalesTax());
		assertEquals(new BigDecimal("0.00"), product3.calcSalesTax());
	}

	@Test
	public void testCalcTotalPrice() {
		assertEquals(new BigDecimal("12.49"), product1.calcTotalPrice());
		assertEquals(new BigDecimal("0.85"), product2.calcTotalPrice());
		assertEquals(new BigDecimal("9.75"), product3.calcTotalPrice());
	}

}
