import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvBillWriter {


    public void write(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){

            for (BillLine billLine : lines) {

                String name = billLine.getName();
                int quantity = billLine.getQuantity();
                String price = billLine.getUnitPrice().toPlainString();
                String discount = billLine.isDiscountApplied() ? "1" : "0";
                String finalTotal = billLine.getFinalTotal().toPlainString();

                String line = name + ";" +
                        quantity + ";" +
                        price + ";" +
                        discount + ";" +
                        finalTotal;

                writer.newLine();
                writer.write(line);
            }

            writer.write("TOTAL;;;;" + total.toPlainString());
            writer.newLine();
            writer.write("ERRORS;;;;" + errors);
            writer.newLine();

        }
    }
}
