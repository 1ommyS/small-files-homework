import Contracts.BillLine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillLineImpl implements BillLine {
    private String name;
    private int quantity;
    private BigDecimal unitPrice;
    private boolean discountApplied;
    private BigDecimal finalTotal;

    public BillLineImpl(String name, int quantity, BigDecimal unitPrice, boolean discountApplied, BigDecimal finalTotal) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discountApplied = discountApplied;
        this.finalTotal = finalTotal;
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
        return (quantity >= 3);
    }

    @Override
    public BigDecimal getFinalTotal() {
        return finalTotal.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return
                name + ";" +
                        quantity + ";" +
                        unitPrice + ";" +
                        discountApplied + ";" +
                        finalTotal;
    }
}
