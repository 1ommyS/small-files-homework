package impl;

import itf.BillLine;
import itf.CsvBillWriter;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CsvBillWriterImpl implements CsvBillWriter {
    @Override
    public void write(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream(path), StandardCharsets.UTF_8))) {


            for (var line : lines) {
                writer.write(
                        line.getName() + ";" +
                                line.getQuantity() + ";" +
                                line.getUnitPrice().toPlainString() + ";" +
                                (line.isDiscountApplied() ? "1" : "0") + ";" +
                                line.getFinalTotal().toPlainString()
                );
                writer.newLine();
            }
            writer.write("TOTAL;;;;" + total.setScale(2).toPlainString());
            writer.newLine();
            writer.write("ERRORS;;;;" + errors);
            writer.newLine();

        }

    }
}
