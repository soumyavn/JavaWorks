package soumyavn.store.SalesTax.catalog;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;

import soumyavn.store.SalesTax.catalog.Product;
import soumyavn.store.SalesTax.catalog.TaxableProduct;

public class TaxableProductTest {

	Product product1 = new TaxableProduct("music CD", new BigDecimal("14.99"));
	Product product2 = new TaxableProduct("bottle of perfume", new BigDecimal("18.99"));

	@Test
	public void testCalcTax() {
		assertEquals(new BigDecimal("1.50"), ((TaxableProduct)product1).calcTax());
		assertEquals(new BigDecimal("1.90"), ((TaxableProduct)product2).calcTax());
	}
	
	@Test
	public void testCalcSalesTax() {
		assertEquals(new BigDecimal("1.50"), product1.calcSalesTax());
		assertEquals(new BigDecimal("1.90"), product2.calcSalesTax());
	}

	@Test
	public void testCalcTotalPrice() {
		assertEquals(new BigDecimal("16.49"), product1.calcTotalPrice());
		assertEquals(new BigDecimal("20.89"), product2.calcTotalPrice());
	}

}
