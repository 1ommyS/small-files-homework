import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BillCalculator {

    private DiscountPolicy policy;

    public BillCalculator(DiscountPolicy policy) {
        this.policy = policy;
    }

    public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {

        ArrayList<BillLine> list = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (ProductLine product : products) {

            BigDecimal price = product.getUnitPrice().setScale(2, RoundingMode.HALF_UP);
            BigDecimal subtotal = price.multiply(BigDecimal.valueOf(product.getQuantity()));
            BigDecimal discount = policy.discountFor(subtotal, product.getQuantity());
            BigDecimal finalTotal = subtotal.subtract(discount).setScale(2, RoundingMode.HALF_UP); // Метод subtract вычисляет одно число из другого <-"Это я так, для себя"

            boolean bool = discount.compareTo(BigDecimal.ZERO) > 0;

            BillLine billLine = new BillLine(product.getName(), product.getQuantity(), price, bool, finalTotal);

            list.add(billLine);
            total = total.add(finalTotal);

        }
        total = total.setScale(2, RoundingMode.HALF_UP);
        return new BillResult<>(list, total);

    }
}
