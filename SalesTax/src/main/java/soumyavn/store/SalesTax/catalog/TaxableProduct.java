package soumyavn.store.SalesTax.catalog;

import java.math.BigDecimal;

import soumyavn.store.SalesTax.util.Util;

public class TaxableProduct extends Product implements Taxable {

	public TaxableProduct(String name, BigDecimal itemPrice) {
		super(name, itemPrice);
		// TODO Auto-generated constructor stub
	}

	public BigDecimal calcTax() {
		BigDecimal tax = this.getItemPrice().multiply(Taxable.RATE);
		BigDecimal taxRounded = Util.RoundToFiveCents(tax);
		return taxRounded;
	}

	@Override
	public BigDecimal calcSalesTax() {
		return calcTax();
	}

}
