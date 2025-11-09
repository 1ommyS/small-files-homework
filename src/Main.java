
public class Main {
    public static void main(String[] args) {

        String input = "/Users/abdul-malik/IdeaProjects/small-files-homework/src/products";
        String output = "/Users/abdul-malik/IdeaProjects/small-files-homework/src/bill.csv";

        try {
            CsvProductReader reader = new CsvProductReader();
            ReadResult<ProductLine> read = reader.read(input);

            DiscountPolicy discount = new DiscountPolicy();
            BillCalculator calculator = new BillCalculator(discount);
            BillResult<BillLine> bill = calculator.calculate(read.getItems());

            CsvBillWriter writer = new CsvBillWriter();
            writer.write(output, bill.getLines(), bill.getTotal(), read.getErrorCount());

            System.out.println("Готово! Файл создан: " + output);
            System.out.println("Итоговая сумма: " + bill.getTotal().toPlainString());
            System.out.println("Ошибочных строк: " + read.getErrorCount());

        } catch (Exception exception) {
            System.err.println("Ошибка при выполнении программы: " + exception.getMessage());
        }
    }
}

