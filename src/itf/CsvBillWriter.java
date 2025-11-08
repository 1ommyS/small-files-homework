package itf;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public interface CsvBillWriter {
    void write(String path,
               ArrayList<BillLine> lines,
               BigDecimal total,
               int errors) throws IOException;
}

