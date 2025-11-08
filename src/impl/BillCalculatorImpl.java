package impl;

import itf.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BillCalculatorImpl implements BillCalculator {

    private final DiscountPolicy policy;

    public BillCalculatorImpl(DiscountPolicy policy) {
        this.policy = policy;
    }

    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLineImpl> products) {

        ArrayList<BillLine> lines = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for (ProductLineImpl product : products) {
            BigDecimal subtotal = product.getUnitPrice().multiply(new BigDecimal(product.getQuantity()));
            BigDecimal discount = policy.discountFor(subtotal, product.getQuantity());
            BigDecimal finalTotal = subtotal.subtract(discount);
            BillLineImpl billLine = new BillLineImpl(
                    product.getName(),
                    product.getQuantity(),
                    product.getUnitPrice().setScale(2, RoundingMode.HALF_UP),
                    discount.compareTo(BigDecimal.ZERO) > 0, // true если скидка > 0
                    finalTotal.setScale(2, RoundingMode.HALF_UP)
            );

            lines.add(billLine);
            total = total.add(finalTotal);
        }

        return new BillResultImpl(lines, total);
    }
}