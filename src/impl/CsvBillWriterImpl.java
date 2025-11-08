package impl;

import interfaces.BillLine;
import interfaces.CsvBillWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class CsvBillWriterImpl implements CsvBillWriter {

    @Override
    public void write(String path,
                      ArrayList<BillLine> lines,
                      BigDecimal total,
                      int errors) throws IOException {

        ArrayList<String> outputLines = new ArrayList<>();

        for (BillLine line : lines) {
            String discountFlag = line.isDiscountApplied() ? "1" : "0";
            String csvLine = String.join(";",
                    line.getName(),
                    String.valueOf(line.getQuantity()),
                    line.getUnitPrice().toPlainString(),
                    discountFlag,
                    line.getFinalTotal().toPlainString()
            );
            outputLines.add(csvLine);
        }

        // служебные строки
        outputLines.add("TOTAL;;;;" + total.toPlainString());
        outputLines.add("ERRORS;;;;" + errors);

        Path filePath = Paths.get(path);
        Files.write(filePath, outputLines, StandardCharsets.UTF_8);
    }
}
