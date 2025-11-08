import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CsvProductReaderImp implements CsvProductReader {
    public ReadResult<ProductLine> read(String path) throws IOException {
        ArrayList<ProductLine> list1 = new ArrayList<>();
        int error = 0;
        boolean oneLine = true;
        Path pathFile = Path.of(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile.toFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (oneLine) {
                    oneLine = false;
                    continue;
                }
                String[] parts = line.split(",");

                for (String line1 : parts) {
                    line1 = line1.trim();
                    String[] parts1 = line1.split(";");

                    if (parts1.length != 3) {
                        error++;
                        continue;
                    }
                    if (!line1.contains(";")) {
                        error++;
                        continue;
                    }
                    String name = parts1[0];
                    int quantity = Integer.parseInt(parts1[1]);
                    BigDecimal price = new BigDecimal(parts1[2]);
                    Product product = new Product(name, quantity, price);
                    list1.add(product);
                }
            }
            return new ProductReadResult(list1, error);
        }
    }
}