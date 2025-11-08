package impl;

import interfaces.BillLine;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillLineImpl implements BillLine {
    private final String name;
    private final int quantity;
    private final BigDecimal unitPrice; // scaled to 2
    private final boolean discountApplied;
    private final BigDecimal finalTotal; // scaled to 2

    public BillLineImpl(String name, int quantity, BigDecimal unitPrice, boolean discountApplied, BigDecimal finalTotal) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
        this.discountApplied = discountApplied;
        this.finalTotal = finalTotal.setScale(2, RoundingMode.HALF_UP);
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
}
