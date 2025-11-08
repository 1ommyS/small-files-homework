package impl;

import interfaces.DiscountPolicy;
import java.math.BigDecimal;

public class QuantityDiscountPolicy implements DiscountPolicy {
    private static final BigDecimal DISCOUNT = new BigDecimal("0.10"); // скидка 10%

    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        if (quantity >= 3) {
            return subtotal.multiply(DISCOUNT);
        }

        return BigDecimal.ZERO;
    }
}
