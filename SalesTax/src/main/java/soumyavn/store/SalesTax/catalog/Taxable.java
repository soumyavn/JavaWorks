package soumyavn.store.SalesTax.catalog;

import java.math.BigDecimal;

public interface Taxable {
	String RATE_VALUE = "0.1";
	BigDecimal RATE = new BigDecimal(RATE_VALUE);

	BigDecimal calcTax();

}
