import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;

public class CsvBillWriterImp implements CsvBillWriter {
    @Override
    public void write(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
        try {
            for (BillLine line : lines) {
                String csvLine =
                        line.getName() + ";" + line.getQuantity() + ";" +
                                line.getUnitPrice().toPlainString() + ";" +
                                (line.isDiscountApplied() ? "1" : "0") + ";" +
                                line.getFinalTotal().toPlainString();

                writer.write(csvLine);
                writer.newLine();
            }

            writer.write("TOTAL;;;;" + total.toPlainString());
            writer.newLine();

            writer.write("ERRORS;;;;" + errors);
            writer.newLine();

        } finally {
            writer.close();
        }
    }
}
