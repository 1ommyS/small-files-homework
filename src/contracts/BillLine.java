package contracts;

import java.math.BigDecimal;

public interface BillLine {
    String getName();
    int getQuantity();
    BigDecimal getUnitPrice();      // 2 знака, HALF_UP
    boolean isDiscountApplied();
    BigDecimal getFinalTotal();     // 2 знака, HALF_UP
}
