package soumyavn.store.SalesTax.catalog;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;

import soumyavn.store.SalesTax.catalog.ImportedProduct;
import soumyavn.store.SalesTax.catalog.Product;

public class ImportedProductTest {

	Product product1 = new ImportedProduct("imported box of chocolates", new BigDecimal("10.00"));
	Product product2 = new ImportedProduct("imported box of chocolates", new BigDecimal("11.25"));

	@Test
	public void testCalcDuty() {
		assertEquals(new BigDecimal("0.50"), ((ImportedProduct)product1).calcDuty());
		assertEquals(new BigDecimal("0.60"), ((ImportedProduct)product2).calcDuty());
	}
	
	@Test
	public void testCalcSalesTax() {
		assertEquals(new BigDecimal("0.50"),product1.calcSalesTax());
		assertEquals(new BigDecimal("0.60"),product2.calcSalesTax());
	}

	@Test
	public void testCalcTotalPrice() {
		assertEquals(new BigDecimal("10.50"),product1.calcTotalPrice());
		assertEquals(new BigDecimal("11.85"),product2.calcTotalPrice());
	}

}
