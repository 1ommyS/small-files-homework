package Contracts;

import java.io.IOException;

public interface CsvProductReader {
    ReadResult<ProductLine> read(String path) throws IOException;
}
