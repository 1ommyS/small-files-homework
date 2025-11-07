import Contracts.ProductLine;

import java.math.BigDecimal;

public class ProductLineImpl implements ProductLine {
    private String name;
    private int quantity;
    private BigDecimal unitPrice;

    public ProductLineImpl(String name, int quantity, BigDecimal unitPrice) {
        ParamsValidator.validateName(name);
        ParamsValidator.validatePrice(unitPrice);
        ParamsValidator.validateQiantity(quantity);

        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
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
    public String toString() {
        return "ProductLineImpl{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
