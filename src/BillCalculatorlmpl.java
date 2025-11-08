import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BillCalculatorlmpl implements BillCalculator{

    private DiscountPolicylmpl discountPolicy = new DiscountPolicylmpl(new BigDecimal(0.1));
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private int errorsCount = 0;

    public DiscountPolicylmpl getDiscountPolicy() {
        return discountPolicy;
    }

    public int getErrorsCount() {
        return errorsCount;
    }

    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLine> products) {
        ArrayList<BillLine> billlines = new ArrayList<>();
        if (products.size() == 0) return null;

        for (ProductLine product : products) {
            if (product == null) {
                errorsCount++;
                continue;
            }
            try{
                BigDecimal unitPrice = product.getUnitPrice();
                int quantity = product.getQuantity();
                if (quantity <= 0){
                    errorsCount++;
                    continue;
                }
                BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
                BigDecimal discount = discountPolicy.discountFor(subtotal, quantity);
                BigDecimal finalTotal = subtotal.subtract(discount);
                if (finalTotal.compareTo(BigDecimal.ZERO) <= 0){
                    errorsCount++;
                    continue;
                }
                finalTotal = finalTotal.setScale(2, RoundingMode.HALF_UP);

                BillLineImpl billLine = new BillLineImpl(product.getName(),
                        quantity,
                        unitPrice.setScale(2, RoundingMode.HALF_UP),
                        discount.compareTo(BigDecimal.ZERO) > 0,
                        finalTotal);

                billlines.add(billLine);
                totalPrice = totalPrice.add(finalTotal);
            } catch (Exception e) {
                throw new RuntimeException("Не удалось прочитать корзину");
            }
        }
        if (billlines.size() == 0) return null;
        return new BillResultlmpl<>(billlines,totalPrice);
    }
}
