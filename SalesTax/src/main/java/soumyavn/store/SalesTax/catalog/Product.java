package soumyavn.store.SalesTax.catalog;

import java.math.BigDecimal;

public class Product {
	private String name;
	private BigDecimal itemPrice;

	public Product(String name, BigDecimal itemPrice) {
		this.name = name;
		this.itemPrice = itemPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public BigDecimal calcTotalPrice() {
		BigDecimal totalPrice = (this.getItemPrice().add(calcSalesTax()));
		BigDecimal totalPriceRnd = totalPrice.setScale(2);
		return totalPriceRnd;

	}

	public BigDecimal calcSalesTax() {
		return (new BigDecimal("0.00").setScale(2));
	}

}
