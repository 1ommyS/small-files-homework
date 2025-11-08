package interfaces;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Записывает результат в CSV ("bill.csv") в формате:
 *  name;quantity;price;discountApplied(0/1);finalTotal
 * После всех позиций дописывает:
 *  TOTAL;;;;<сумма_по_всем>
 *  ERRORS;;;;<количество_пропущенных_строк>
 *
 * Требования:
 *  • Кодировка UTF-8; BufferedWriter; без Stream API.
 *  • Денежные значения выводить через BigDecimal#toPlainString().
 */
public interface CsvBillWriter {
    void write(String path,
               ArrayList<BillLine> lines,
               BigDecimal total,
               int errors) throws IOException;
}
