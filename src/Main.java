import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        CsvProductReaderlmpl productReaderlmpl = new CsvProductReaderlmpl();
        ReadResult<ProductLine> readResult = productReaderlmpl.read("C:/Lessons/small-files-homework/src/products.csv");

        BillCalculatorlmpl billCalculator = new BillCalculatorlmpl();
        BillResult<BillLine> billResult = billCalculator.calculate(readResult.getItems());


        CsvProductWriterImpl productWriter = new CsvProductWriterImpl();
        productWriter.write("C:/Lessons/small-files-homework/src/productsWrite.csv",
                billResult.getLines(),
                billResult.getTotal(),
                billCalculator.getErrorsCount()
                );

    }
}