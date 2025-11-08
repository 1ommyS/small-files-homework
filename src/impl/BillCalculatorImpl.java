package impl;

import interfaces.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public final class BillCalculatorImpl implements BillCalculator {
    private final DiscountPolicy policy;

    public BillCalculatorImpl(DiscountPolicy policy) {
        this.policy = policy;
    }

    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {
        ArrayList<BillLine> lines = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (ProductLine product : products) {
            BigDecimal subtotal = product.getUnitPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
            BigDecimal discount = policy.discountFor(subtotal, product.getQuantity());
            BigDecimal finalTotal = subtotal.subtract(discount);

            boolean discountApplied = discount.compareTo(BigDecimal.ZERO) > 0;

            BillLine billLine = new BillLineImpl(
                    product.getName(),
                    product.getQuantity(),
                    product.getUnitPrice(),
                    discountApplied,
                    finalTotal
            );

            lines.add(billLine);
            total = total.add(billLine.getFinalTotal());
        }

        total = total.setScale(2, RoundingMode.HALF_UP);
        return new BillResultImpl<>(lines, total);
    }
}
