import Contracts.DiscountPolicy;

import java.math.BigDecimal;

public class DiscountPolicyImpl implements DiscountPolicy {
    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        BigDecimal discount = new BigDecimal("0");
        if (quantity >= 3) {
            discount = subtotal.multiply(new BigDecimal(0.1));
            return discount;
        }

        return discount;
    }
}
