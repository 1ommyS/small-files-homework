package interfaces;

import java.io.IOException;

/**
 * Читает входной CSV (по умолчанию "products.csv") и формирует ReadResult<ProductLine>.
 * Правила:
 *  • Пустые и начинающиеся с '#' строки — игнорируются.
 *  • Ожидается формат "name;quantity;price" (ровно 3 поля).
 *  • quantity парсится как int >= 0; price — BigDecimal из строки.
 *  • Ошибочные строки пропускаются и увеличивают счётчик ошибок.
 * Ограничения: без Stream API; использовать BufferedReader.
 */
public interface CsvProductReader {
    ReadResult<ProductLine> read(String path) throws IOException;
}
