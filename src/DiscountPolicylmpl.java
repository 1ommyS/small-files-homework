import java.math.BigDecimal;

public class DiscountPolicylmpl implements DiscountPolicy{
    private BigDecimal discount;
    private static final int MIN_QUNTITY = 3;

    public DiscountPolicylmpl(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        if (quantity >= MIN_QUNTITY){
            return subtotal.multiply(discount);
        }
        return BigDecimal.ZERO;
    }


}
