package impl;

import interfaces.CsvProductReader;
import interfaces.ProductLine;
import interfaces.ReadResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CsvProductReaderImpl implements CsvProductReader {
    @Override
    public ReadResult<ProductLine> read(String path) throws IOException {
        Path filePath = Path.of(path);
        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(filePath));
        ArrayList<ProductLine> products = new ArrayList<>();
        int errorCount = 0;

        for (String line : lines) {
            if (line == null) {
                errorCount++;
                continue;
            }

            line = line.trim();

            // пропускаем пустые строки и комментарии
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }

            String[] fields = line.split(";", -1); // -1 сохраняем концевые пустые значения

            // проверяем, что ровно 3 поля
            if (fields.length != 3) {
                errorCount++;
                continue;
            }

            String name = fields[0].trim();
            String quantityStr = fields[1].trim();
            String priceStr = fields[2].trim();

            // проверяем на пустоту после trim
            if (name.isEmpty() || quantityStr.isEmpty() || priceStr.isEmpty()) {
                errorCount++;
                continue;
            }

            try {
                int quantity = Integer.parseInt(quantityStr);
                ProductLine product = new ProductLineImpl(name, quantity, priceStr);
                products.add(product);
            } catch (IllegalArgumentException e) {
                errorCount++;
            }
        }

        return new ReadResultImpl<>(products, errorCount);
    }
}
