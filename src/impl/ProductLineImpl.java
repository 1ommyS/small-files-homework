package impl;

import itf.ProductLine;

import java.math.BigDecimal;

public class ProductLineImpl implements ProductLine {

    private String name;
    private int quantity;
    BigDecimal unitPrice;

    public ProductLineImpl(String name, int quantity, BigDecimal unitPrice) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Некорректно введено поле name");
        this.name = name;

        if (quantity < 0)
            throw new IllegalArgumentException("Некорректно введено поле quantity");
        this.quantity = quantity;

        if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Некорректно введено поле unitPrice");
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
}
