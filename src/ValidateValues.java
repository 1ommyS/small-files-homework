import java.math.BigDecimal;

public class ValidateValues {
    public static void validateName(String name){
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Задано некорректное имя");
        }
    }

    public static void validateValue(int value){
        if (value < 0){
            throw new IllegalArgumentException("Задано некорректное значение");
        }
    }

    public static void validateValue(BigDecimal value){
        if (value.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Задано некорректное значение");
        }
    }
}
