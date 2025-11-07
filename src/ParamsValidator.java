import Exceptions.NameInvalidException;
import Exceptions.PriceInvalidException;
import Exceptions.QuantityInvalidException;

import java.math.BigDecimal;

public class ParamsValidator {
    public static void validateName(String name) {
        if (name != null && !name.isEmpty()) return;

        throw new NameInvalidException("Строка не должна быть пустой");
    }

    public static void validateQiantity(int quantity) {
        if (quantity <= 0)
            throw new QuantityInvalidException("Количество продуктов не может быть <= 0");
    }

    public static void validatePrice(BigDecimal price) {
        if (price.compareTo(new BigDecimal(0)) <= 0) {
            throw new PriceInvalidException("Цена не может быть <= 0");
        }
    }
}
