package soumyavn.store.SalesTax.util;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.TestCase;
import soumyavn.store.SalesTax.util.Util;

public class UtilTest extends TestCase {

	BigDecimal dec1 = new BigDecimal("234.6500000000001");
	BigDecimal dec2 = new BigDecimal("234.651");
	BigDecimal dec3 = new BigDecimal("234.665");
	BigDecimal dec4 = new BigDecimal("234.671");
	BigDecimal dec5 = new BigDecimal("234.688");
	BigDecimal dec6 = new BigDecimal("234.690");
	BigDecimal dec7 = new BigDecimal("234.600");
	BigDecimal dec8 = new BigDecimal("234.601");
	BigDecimal dec9 = new BigDecimal("234.625");
	BigDecimal dec10 = new BigDecimal("234.649");

	@Test
	public void testRoundToFiveCents() {
		assertEquals(new BigDecimal("234.70"), Util.RoundToFiveCents(dec1));
		assertEquals(new BigDecimal("234.70"), Util.RoundToFiveCents(dec2));
		assertEquals(new BigDecimal("234.70"), Util.RoundToFiveCents(dec3));
		assertEquals(new BigDecimal("234.70"), Util.RoundToFiveCents(dec4));
		assertEquals(new BigDecimal("234.70"), Util.RoundToFiveCents(dec5));
		assertEquals(new BigDecimal("234.70"), Util.RoundToFiveCents(dec6));
		assertEquals(new BigDecimal("234.60"), Util.RoundToFiveCents(dec7));
		assertEquals(new BigDecimal("234.65"), Util.RoundToFiveCents(dec8));
		assertEquals(new BigDecimal("234.65"), Util.RoundToFiveCents(dec9));
		assertEquals(new BigDecimal("234.65"), Util.RoundToFiveCents(dec10));

	}

}
