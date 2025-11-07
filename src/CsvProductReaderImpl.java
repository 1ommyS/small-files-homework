import Contracts.CsvProductReader;
import Contracts.ProductLine;
import Contracts.ReadResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvProductReaderImpl implements CsvProductReader {
    @Override
    public ReadResult<ProductLine> read(String path) throws IOException {
        ArrayList<ProductLine> list = new ArrayList<>();
        int errorCount = 0;

        List<String> lines = null;
        lines = Files.readAllLines(Path.of(path));

        lines = lines.subList(1, lines.size());

        for (String line : lines) {

            String[] parts = line.trim().split(";");

            ProductLineImpl item = new ProductLineImpl(
                    parts[0],
                    Integer.parseInt(parts[1]),
                    new BigDecimal(parts[2])
            );
            list.add(item);
        }

        return new ReadResultImpl<>(list, errorCount);

    }


}
