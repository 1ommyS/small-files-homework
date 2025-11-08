package impl;

import itf.DiscountPolicy;

import java.math.BigDecimal;

public class DiscountPolicyImpl implements DiscountPolicy {


    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        if (quantity >= 3) {

            return subtotal.multiply(new BigDecimal("0.1"));
        }
        return BigDecimal.ZERO;

    }
}
