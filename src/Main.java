import impl.*;
import itf.*;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        CsvProductReader reader = new CsvProductReaderImpl();
        ReadResult<ProductLine> readResult = reader.read("/Users/elizavetaisakova/JAVA/small-files-homework/src/product.csv");

        DiscountPolicy policy = new DiscountPolicyImpl();

        BillCalculator calculator = new BillCalculatorImpl(policy);
        BillResult<BillLine> bill = calculator.calculate(readResult.getItems());

        CsvBillWriter writer = new CsvBillWriterImpl();
        writer.write("bill.csv", bill.getLines(), bill.getTotal(), readResult.getErrorCount());


    }
}