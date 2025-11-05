package contracts;

import java.io.IOException;

public interface CsvProductReader {
    ReadResult<ProductLine> read() throws IOException;
}
