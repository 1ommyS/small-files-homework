package interfaces;

import java.math.BigDecimal;

/**
 * Рассчитанная позиция счёта.
 * Контракт:
 *  • unitPrice и finalTotal на уровне объекта уже приведены к масштабу 2 и округлены HALF_UP. .setScale(2, RoundingMode.HALF_UP)
 *  • discountApplied должен быть true, если на позицию применена скидка.
 */
public interface BillLine {
    String getName();
    int getQuantity();
    BigDecimal getUnitPrice();      // 2 знака, HALF_UP
    boolean isDiscountApplied();
    BigDecimal getFinalTotal();     // 2 знака, HALF_UP
}
