import java.math.BigDecimal;

public class BillLine {

    private String name;
    private int quantity;
    private BigDecimal unitPrice;
    private boolean discountApplied;
    private BigDecimal finalTotal;

    public BillLine(String name, int quantity, BigDecimal unitPrice, boolean discountApplied, BigDecimal finalTotal) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discountApplied = discountApplied;
        this.finalTotal = finalTotal;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }

    public BigDecimal getFinalTotal() {
        return finalTotal;
    }
}
