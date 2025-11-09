import java.math.BigDecimal;

public class DiscountPolicy {

    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        if (quantity > 3) {
            return subtotal.multiply(new BigDecimal("0.9"));
        }
        return BigDecimal.ZERO;
    }
}
