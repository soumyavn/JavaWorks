package soumyavn.store.SalesTax.catalog;
import java.math.BigDecimal;

public interface Imported {
	String DUTY_VALUE="0.05";
	BigDecimal DUTY=new BigDecimal(DUTY_VALUE);
	BigDecimal calcDuty();

}
