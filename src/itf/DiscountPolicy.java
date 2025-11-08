package itf;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal discountFor(BigDecimal subtotal, int quantity);
}
