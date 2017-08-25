package soumyavn.store.SalesTax.catalog;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import soumyavn.store.SalesTax.catalog.ImportedTaxableProduct;
import soumyavn.store.SalesTax.catalog.Product;

public class ImportedTaxableProductTest {

	Product product1 = new ImportedTaxableProduct("imported bottle of perfume", new BigDecimal("47.50"));
	Product product2 = new ImportedTaxableProduct("imported bottle of perfume ", new BigDecimal("27.99"));

	@Test
	public void testCalcTax() {
		assertEquals(new BigDecimal("4.75"), ((ImportedTaxableProduct)product1).calcTax());
		assertEquals(new BigDecimal("2.80"), ((ImportedTaxableProduct)product2).calcTax());
	}
	
	@Test
	public void testCalcDuty() {
		assertEquals(new BigDecimal("2.40"), ((ImportedTaxableProduct)product1).calcDuty());
		assertEquals(new BigDecimal("1.40"), ((ImportedTaxableProduct)product2).calcDuty());
	}
//	
	@Test
	public void testCalcSalesTax() {
		assertEquals(new BigDecimal("7.15"), product1.calcSalesTax());
		assertEquals(new BigDecimal("4.20"), product2.calcSalesTax());
	}

	@Test
	public void testCalcTotalPrice() {
		assertEquals(new BigDecimal("54.65"), product1.calcTotalPrice());
		assertEquals(new BigDecimal("32.19"), product2.calcTotalPrice());
	}


}
