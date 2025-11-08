import impl.BillCalculatorImpl;
import impl.CsvBillWriterImpl;
import impl.CsvProductReaderImpl;
import impl.QuantityDiscountPolicy;
import interfaces.*;

import java.io.IOException;

/**
 * Алгоритм:
 *  1) Прочитать вход: CsvProductReader#read → ReadResult<ProductLine>;
 *  2) Создать DiscountPolicy (скидка 10% при quantity ≥ 3);
 *  3) Посчитать счёт: BillCalculator#calculate → BillResult<BillLine>;
 *  4) Записать результат: CsvBillWriter#write (включая TOTAL и ERRORS).
 *
 * Реализация должна:
 *  • использовать BigDecimal для денег;
 *  • обходить коллекции через циклы (без Stream API);
 *  • использовать дженерики и ArrayList;
 *  • аккуратно округлять денежные значения до 2 знаков (HALF_UP) на выходе.
 */
public class Main {
    private static final String DEFAULT_PATH_TO_FILES = "D:\\Java\\home work\\Files\\src\\resources";

    public static void main(String[] args) {
        try {
            CsvProductReader reader = new CsvProductReaderImpl();
            ReadResult<ProductLine> readResult = reader.read(DEFAULT_PATH_TO_FILES + "\\products.csv");

            DiscountPolicy policy = new QuantityDiscountPolicy();
            BillCalculator calculator = new BillCalculatorImpl(policy);
            BillResult<BillLine> billResult = calculator.calculate(readResult.getItems());

            CsvBillWriter writer = new CsvBillWriterImpl();
            writer.write(DEFAULT_PATH_TO_FILES + "\\bill.csv",
                    billResult.getLines(),
                    billResult.getTotal(),
                    readResult.getErrorCount());

        } catch (IOException e) {
            System.err.println("Ошибка чтения-записи: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}