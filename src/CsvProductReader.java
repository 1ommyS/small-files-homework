import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface CsvProductReader {
    ReadResult<ProductLine> read(String path) throws IOException;
}