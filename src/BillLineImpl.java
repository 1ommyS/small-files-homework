import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillLineImpl implements BillLine{
    private final String name;
    private final int quantity;
    private final BigDecimal unitPrice;
    private final boolean discountApplied;
    private final BigDecimal finalTotal;

    public BillLineImpl(String name, int quantity, BigDecimal unitPrice, boolean discountApplied, BigDecimal finalTotal) {
        ValidateValues.validateName(name);
        ValidateValues.validateValue(quantity);
        ValidateValues.validateValue(unitPrice);
        ValidateValues.validateValue(finalTotal);

        this.name = name;
        this.quantity = quantity;
        this.unitPrice = scaleValue(unitPrice);
        this.discountApplied = discountApplied;
        this.finalTotal =  scaleValue(finalTotal);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean isDiscountApplied() {
        return discountApplied;
    }

    @Override
    public BigDecimal getFinalTotal() {
        return finalTotal;
    }

    private BigDecimal scaleValue(BigDecimal value){
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
