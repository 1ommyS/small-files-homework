package interfaces;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Результат расчёта счёта.
 * @param <T> тип рассчитанных строк (в данном случае — BillLine).
 *
 * Контракт:
 *  • getLines() — ArrayList всех позиций счёта.
 *  • getTotal() — общая сумма по всем позициям, округлённая до 2 знаков HALF_UP.
 */
public interface BillResult<T> {
    ArrayList<T> getLines();
    BigDecimal getTotal();
}
