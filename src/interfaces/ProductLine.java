package interfaces;

import java.math.BigDecimal;

/**
 * Представляет одну строку входного CSV "name;quantity;price".
 * Контракт:
 *  • Имплементация должна быть неизменяемой.
 *  • Валидировать в конструкторе:
 *      - name не пустой (после trim);
 *      - quantity >= 0;
 *      - unitPrice >= 0.
 *  • Денежные значения хранить в BigDecimal, создавать только из строки.
 */
public interface ProductLine {
    String getName();
    int getQuantity();
    BigDecimal getUnitPrice();
}
