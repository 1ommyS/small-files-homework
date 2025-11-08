package interfaces;

import java.math.BigDecimal;

/**
 * Политика скидок.
 * Контракт:
 *  • На вход поступает subtotal = unitPrice * quantity (без финального округления).
 *  • Вернуть абсолютную сумму скидки (>= 0), масштаб не фиксируется — финальное округление выполняет вызывающая сторона.
 */
public interface DiscountPolicy {
    BigDecimal discountFor(BigDecimal subtotal, int quantity);
}
