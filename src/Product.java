import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product implements ProductLine, BillLine, DiscountPolicy {
    private String name;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal getFinalTotal;
    private boolean discountApplied;

    public Product(String name, int quantity, BigDecimal unitPrice) {
        this(name, quantity, unitPrice, false);
    }

    public Product(String name, int quantity, BigDecimal unitPrice, boolean discountApplied) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
        this.discountApplied = discountApplied;
        Utilits.validProduct(name, quantity, unitPrice);
    }

    public Product(String name, int quantity, BigDecimal unitPrice, boolean discountApplied, BigDecimal getFinalTotal) {
        this(name, quantity, unitPrice, discountApplied);
        this.getFinalTotal = getFinalTotal;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
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
        return unitPrice.multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        return Utilits.subtotal(subtotal, quantity);
    }

}
