/*
@autrhor Denys
@project lab4
@class RomanToIntegerConverter
@version 1.0.0
@sinc 12.04.2025 - 16 - 42
*/
package converter;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerConverter {

    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static int romanToInt(String roman) {
        if (roman == null || roman.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        roman = roman.trim(); // Видаляємо пробіли на початку/в кінці
        int total = 0;
        int prevValue = 0;

        int repeatCount = 1;
        char prevChar = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char ch = roman.charAt(i);

            if (!romanMap.containsKey(ch)) {
                throw new IllegalArgumentException("Invalid Roman numeral character: " + ch);
            }

            // Повторення символів
            if (ch == prevChar) {
                repeatCount++;

                if ((ch == 'V' || ch == 'L' || ch == 'D') && repeatCount > 1) {
                    throw new IllegalArgumentException("Invalid repetition of Roman numeral: " + ch);
                }

                if (repeatCount > 3) {
                    throw new IllegalArgumentException("Too many repetitions of Roman numeral: " + ch);
                }
            } else {
                repeatCount = 1;
            }

            int currentValue = romanMap.get(ch);

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
                prevValue = currentValue;
            }

            prevChar = ch;
        }

        return total;
    }

}
