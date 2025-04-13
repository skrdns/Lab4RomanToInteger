/*
@autrhor Denys
@project lab4
@class Main
@version 1.0.0
@sinc 12.04.2025 - 16 - 41
*/

package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Конвертер римських чисел у цілі числа");
        System.out.println("Введіть римське число (наприклад, XIV):");

        String input = scanner.nextLine();

        try {
            int result = RomanToIntegerConverter.romanToInt(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
