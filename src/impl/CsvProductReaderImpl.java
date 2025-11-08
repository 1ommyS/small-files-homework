package impl;

import itf.CsvProductReader;
import itf.ProductLine;
import itf.ReadResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvProductReaderImpl implements CsvProductReader {

    @Override
    public ReadResult<ProductLine> read(String path) throws IOException {
        ArrayList<ProductLine> items = new ArrayList<>();
        int errorCount = 0;

        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String line;


        while ((line = bf.readLine()) != null) {
            //Пустые и начинающиеся с '#' строки — игнорируются.
            if (line.isEmpty())
                continue;
            if (line.startsWith("#"))
                continue;

            String[] parts = line.trim().split(";");

            //(ровно 3 поля)
            if (parts.length != 3) {
                errorCount++;
                continue;
            }

            try {
                String name = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                BigDecimal price = new BigDecimal(parts[2]);
                ProductLine product = new ProductLineImpl(name, quantity, price);
                items.add(product);

            } catch (Exception e) {
                errorCount++;
            }

        }
        bf.close();
        return new ReadResultImpl<>(items, errorCount);
    }
}

