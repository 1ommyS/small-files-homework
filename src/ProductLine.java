import java.math.BigDecimal;

public class ProductLine {

    private String name;
    private int quantity;
    private BigDecimal unitPrice;

    public ProductLine(String name, int quantity, BigDecimal unitPrice) {

        if (name == null || name.equals(""))
            throw new NameNullException("Пустая строка");
        if (quantity < 0)
            throw new LessThanZeroException("Количество меньше нуля");
        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) < 0)
            throw new WrongPrice("Ошибка в цене");

        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    String getName() {
        return name;
    }

    int getQuantity() {
        return quantity;
    }

    BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
