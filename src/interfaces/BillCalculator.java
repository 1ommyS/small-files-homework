package interfaces;

import java.util.ArrayList;

/**
 * Выполняет расчёт счёта:
 *  1) subtotal = unitPrice * quantity (BigDecimal);
 *  2) discount = policy.discountFor(subtotal, quantity);
 *  3) finalTotal = subtotal - discount;
 *  4) Привести unitPrice и finalTotal к масштабу 2 (HALF_UP) в создаваемых BillLine;
 *  5) total = сумма всех finalTotal, также 2 знака, HALF_UP.
 * Ограничения: без Stream API; обход ArrayList через циклы.
 */
public interface BillCalculator {
    BillResult<BillLine> calculate(ArrayList<ProductLine> products);
}
