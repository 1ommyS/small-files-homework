import java.math.BigDecimal;

public class ProductLineImpl implements ProductLine{
    private String name;
    private int quantity;
    private BigDecimal price;

    public ProductLineImpl(String name, int quantity, BigDecimal price) {
        ValidateValues.validateName(name);
        ValidateValues.validateValue(quantity);
        ValidateValues.validateValue(price);
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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
        return price;
    }

    @Override
    public String toString() {
        return "ProductLineImpl{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
