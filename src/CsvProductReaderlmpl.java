import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvProductReaderlmpl implements CsvProductReader {
    private String line;
    private int errorCount;

    @Override
    public ReadResult<ProductLine> read(String path) throws IOException {
        ArrayList<ProductLine> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    errorCount++;
                    continue;
                }
                String[] partsOfLine = line.split(";");
                if (partsOfLine[0].isEmpty() || partsOfLine[1].isEmpty() || partsOfLine[2].isEmpty()) {
                    errorCount++;
                    continue;
                }
                ProductLineImpl productLine = new ProductLineImpl(partsOfLine[0],
                        Integer.parseInt(partsOfLine[1]),
                        new BigDecimal(partsOfLine[2]));
                items.add(productLine);

            }
            //проверка продуктов
            for (ProductLine l : items) {
                System.out.println(l.toString());
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Не удалось прочитать файл");
        }

        return new ReadResultImpl<>(items, errorCount);
    }
}
