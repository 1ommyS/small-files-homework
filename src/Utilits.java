import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilits {
    //Валидация продукта
    public static boolean validName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Наменование не может быть пустым");
        return true;
    }

    public static boolean validQantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Параметр не должен быть меньше 0");
        return true;
    }

    public static boolean validUnitPrice(BigDecimal bigDecimal) {
        if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Параметр не должен быть меньше 0");
        return true;
    }

    public static boolean validProduct(String name, int quantity, BigDecimal bigDecimal) {
        return validName(name) && validQantity(quantity) && validUnitPrice(bigDecimal);
    }

    //считали текст и выкинули кудато
    public static List<String> read(String path) {
        List<String> readFile = null;
        try {
            readFile = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Чтото пошло не так при чтении файла");
        }
        return readFile.subList(1, readFile.size());
    }

    //создал список обьектов // и список ошибок каунтер
    public static ReadResult<ProductLine> product(List<String> list) {
        int error = 0;
        ArrayList<ProductLine> list1 = new ArrayList<>();
        for (String line : list) {
            String[] parts = line.split(",");

            for (String line1 : parts) {
                line1 = line1.trim();
                String[] parts1 = line1.split(";");

                if (parts1.length != 3) {
                    error++;
                    continue;
                }
                if (!line1.contains(";")) {
                    error++;
                    continue;
                }
                String name = parts1[0];
                int quantity = Integer.parseInt(parts1[1]);
                BigDecimal price = new BigDecimal(parts1[2]);
                Product product = new Product(name, quantity, price);
                list1.add(product);
            }
        }
        return new ProductReadResult(list1,error);
    }

    //считает скидку
    public static BigDecimal subtotal(BigDecimal unitPrice, int quantity) {
        BigDecimal subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
        if (quantity >= 3) {
            BigDecimal discount = subtotal.multiply(new BigDecimal("0.10"));
            BigDecimal finalTotal = subtotal.subtract(discount);
            return finalTotal.setScale(2, RoundingMode.HALF_UP);
        }
        return subtotal.setScale(2, RoundingMode.HALF_UP);
    }
}
