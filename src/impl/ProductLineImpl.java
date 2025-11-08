package impl;

import interfaces.ProductLine;
import java.math.BigDecimal;

public class ProductLineImpl implements ProductLine {
    private final String name;
    private final int quantity;
    private final BigDecimal unitPrice;

    public ProductLineImpl(String name, int quantity, String priceStr) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Количество продуктов не может быть отрицательным");
        }

        String trimmedPrice = priceStr.trim();
        BigDecimal price = new BigDecimal(trimmedPrice);
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена продукта не может быть отрицатеотной");
        }

        this.name = trimmedName;
        this.quantity = quantity;
        this.unitPrice = price;
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
}
