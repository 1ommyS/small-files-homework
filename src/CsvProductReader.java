import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvProductReader {

    public ReadResult<ProductLine> read(String path) {

        int errors = 0;
        ArrayList<ProductLine> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null) {

                if (line.startsWith("#")) {
                    continue;
                }

                String[] item = line.split(";");

                if (item.length == 3) {
                    list.add(new ProductLine(item[0], Integer.parseInt(item[1]), new BigDecimal(item[2])));

                } else {
                    errors++;
                    continue;
                }



            }

        } catch (IOException exception) {
            errors++;
        }

        return new ReadResult<>(list, errors);
    }
}
