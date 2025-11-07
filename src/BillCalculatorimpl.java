import Contracts.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BillCalculatorimpl implements BillCalculator {
    private static DiscountPolicyImpl discountPolicy = new DiscountPolicyImpl();

    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {
        ArrayList<BillLine> lines = new ArrayList<>();
        BigDecimal allTotalPrice = new BigDecimal("0");
        BillResultImpl billResult = new BillResultImpl<>(lines, allTotalPrice);

        for (ProductLine product : products) {
            BigDecimal subtotal = product.getUnitPrice().multiply(new BigDecimal(product.getQuantity()));
            BigDecimal discount = discountPolicy.discountFor(subtotal, product.getQuantity());
            BigDecimal finalTotal = subtotal.subtract(discount);
            allTotalPrice = allTotalPrice.add(finalTotal);
            boolean hasDiscount = discount.compareTo(new BigDecimal("0")) > 0;
            BillLineImpl billLine = new BillLineImpl(product.getName(), product.getQuantity(), product.getUnitPrice(),
                    hasDiscount, finalTotal);

            lines.add(billLine);
        }
        return billResult;
    }
}
