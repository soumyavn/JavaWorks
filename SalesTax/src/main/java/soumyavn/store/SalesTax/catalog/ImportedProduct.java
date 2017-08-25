package soumyavn.store.SalesTax.catalog;

import java.math.BigDecimal;

import soumyavn.store.SalesTax.util.Util;

public class ImportedProduct extends Product implements Imported {

	public ImportedProduct(String name, BigDecimal itemPrice) {
		super(name, itemPrice);
		// TODO Auto-generated constructor stub
	}

	public BigDecimal calcDuty() {
		BigDecimal duty = this.getItemPrice().multiply(Imported.DUTY);
		BigDecimal dutyRounded = Util.RoundToFiveCents(duty);
		return dutyRounded;
	}

	@Override
	public BigDecimal calcSalesTax() {

		BigDecimal salesTax = calcDuty();
		return salesTax;
	}

}
