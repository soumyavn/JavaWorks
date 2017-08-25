package soumyavn.store.SalesTax;

import java.math.BigDecimal;
import java.util.ArrayList;

import soumyavn.store.SalesTax.catalog.Product;

public class ShoppingCart {
	private ArrayList<Product> items;

	public ShoppingCart(ArrayList<Product> items) {
		this.items = items;
	}

	public ArrayList<Product> getItems() {
		return items;
	}

	public BigDecimal getCartTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Product product : items) {
			total = total.add(product.calcTotalPrice());
		}
		return total;

	}

	public BigDecimal getCartSalesTaxTotal() {
		BigDecimal salesTax = new BigDecimal(0);

		for (Product product : items) {
			salesTax = salesTax.add(product.calcSalesTax());
		}
		return salesTax;

	}

}
