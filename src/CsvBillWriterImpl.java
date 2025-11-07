import Contracts.BillLine;
import Contracts.CsvBillWritter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvBillWriterImpl implements CsvBillWritter {
    private BillLineImpl billLine;


    @Override
    public void write(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {
        try (FileWriter wr = new FileWriter(path);) {
            wr.append("name;quantity;unitPrice;discountApplied;finalTotal\n");
            for (BillLine line : lines) {
                wr.write(line.toString() + "\n");
            }
            wr.write("TOTAL " + total.toPlainString() + "\n");
            wr.write("ERRORS " + errors + "\n");
        }


    }
}
