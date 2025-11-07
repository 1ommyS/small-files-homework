import Contracts.BillLine;
import Contracts.BillResult;
import Contracts.ProductLine;
import Contracts.ReadResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CsvProductReaderImpl reader = new CsvProductReaderImpl();
        BillCalculatorimpl calculator = new BillCalculatorimpl();
        CsvBillWriterImpl writer = new CsvBillWriterImpl();

        try {
            ReadResult<ProductLine> readResult = reader.read("C:\\Users\\Динар\\IdeaProjects\\small-files-homework1\\src\\Products.Csv");
            BillResult<BillLine> resultCalculate =  calculator.calculate(readResult.getItems());
            ArrayList<BillLine> list =  resultCalculate.getLines();
            BigDecimal totalPrice = resultCalculate.getTotal();
            int errors = readResult.getErrorCount();
            writer.write("C:\\Users\\Динар\\IdeaProjects\\small-files-homework1\\src\\Bill.Csv", list, totalPrice, errors);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}