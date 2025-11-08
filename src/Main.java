import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "/Users/ryltsovsergei/Idealessonthree/small-files-homework1/src/text.csv";
        CsvProductReader csvProductReader = new CsvProductReaderImp();// Догодался до конструктора только когда сделал
        ReadResult<ProductLine> readResult = csvProductReader.read(path);

        BillCalculator billCalculator = new BillCalculatorImp();

        BillResult<BillLine> billResult = billCalculator.calculate(readResult.getItems());

        CsvBillWriter csvBillWriter = new CsvBillWriterImp();
        String outputPath = "/Users/ryltsovsergei/Idealessonthree/small-files-homework1/src/bill.csv";

        csvBillWriter.write(outputPath, billResult.getLines(),  billResult.getTotal(), readResult.getErrorCount());
    }
}