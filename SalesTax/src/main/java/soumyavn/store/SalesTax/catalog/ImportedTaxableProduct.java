package soumyavn.store.SalesTax.catalog;

import java.math.BigDecimal;

import soumyavn.store.SalesTax.util.Util;

public class ImportedTaxableProduct extends Product implements Taxable, Imported {

	public ImportedTaxableProduct(String name, BigDecimal itemPrice) {
		super(name, itemPrice);
		// TODO Auto-generated constructor stub
	}

	public BigDecimal calcDuty() {
		BigDecimal duty = this.getItemPrice().multiply(Imported.DUTY);
		BigDecimal dutyRounded = Util.RoundToFiveCents(duty);
		return dutyRounded;
	}

	public BigDecimal calcTax() {
		BigDecimal tax = this.getItemPrice().multiply(Taxable.RATE);
		BigDecimal taxRounded = Util.RoundToFiveCents(tax);
		return taxRounded;
	}

	@Override
	public BigDecimal calcSalesTax() {
		BigDecimal salesTax = calcDuty().add(calcTax());
		return salesTax;
	}

}
