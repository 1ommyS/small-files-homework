import Contracts.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BillCalculatorimpl implements BillCalculator {
    private static DiscountPolicyImpl discountPolicy = new DiscountPolicyImpl();

    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {
        ArrayList<BillLine> lines = new ArrayList<>();
        BigDecimal allTotalPrice = new BigDecimal("0");

        for (ProductLine product : products) {
            BigDecimal subtotal = product.getUnitPrice().multiply(new BigDecimal(product.getQuantity()).setScale(2, RoundingMode.HALF_UP));
            BigDecimal discount = discountPolicy.discountFor(subtotal, product.getQuantity());
            BigDecimal finalTotal = subtotal.subtract(discount).setScale(2,RoundingMode.HALF_UP);
            allTotalPrice = allTotalPrice.add(finalTotal);
            boolean hasDiscount = discount.compareTo(new BigDecimal("0")) > 0;
            BillLineImpl billLine = new BillLineImpl(product.getName(), product.getQuantity(), product.getUnitPrice(),
                    hasDiscount, finalTotal);

            lines.add(billLine);
        }
        return new BillResultImpl<>(lines, allTotalPrice);
    }
}
