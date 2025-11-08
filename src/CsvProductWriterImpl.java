
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;

public class CsvProductWriterImpl implements CsvBillWriter{

    @Override
    public void write(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write("name;quantity;price;discountApplied(0/1);finalTotal");
            writer.newLine();

            for (BillLine line: lines){
                writer.write(line.getName());
                writer.write(";");
                writer.write(String.valueOf(line.getQuantity()));
                writer.write(";");
                writer.write(line.getUnitPrice().toPlainString());
                writer.write(";");
                writer.write(line.isDiscountApplied() ? "1" : "0");
                writer.write(";");
                writer.write(line.getFinalTotal().toPlainString());
                writer.newLine();
            }

            writer.write("TOTAL;;;;");
            if (total != null) {
                writer.write(total.toPlainString());
            }
            writer.newLine();

            writer.write("ERRORS;;;;");
            writer.write(String.valueOf(errors));
            writer.newLine();

            writer.flush();

        } catch (RuntimeException e) {
            throw new RuntimeException("Не удалось записать файл "+e.getMessage());
        }

    }
}
