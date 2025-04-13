/*
@autrhor Denys
@project lab4
@class RomanToIntegerConverterTest
@version 1.0.0
@sinc 12.04.2025 - 16 - 43
*/

package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import converter.RomanToIntegerConverter;

public class RomanToIntegerConverterTest {

    private final RomanToIntegerConverter converter = new RomanToIntegerConverter();

    // 1. Перевірка винятку при порожньому рядку
    @Test
    void testEmptyInputThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt(""));
        assertEquals("Input cannot be null or empty.", e.getMessage());
    }

    // 2. Перевірка винятку при null
    @Test
    void testNullInputThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt(null));
        assertEquals("Input cannot be null or empty.", e.getMessage());
    }

    // 3. Перевірка винятку при наявності невалідного символу
    @Test
    void testInvalidCharactersThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("A"));
        assertEquals("Invalid Roman numeral character: A", e.getMessage());
    }

    // 4. Перевірка винятку для нижнього регістру
    @Test
    void testLowercaseInputThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("x"));
        assertEquals("Invalid Roman numeral character: x", e.getMessage());
    }

    // 5. Перевірка винятку на наявність не римських символів у рядку
    @Test
    public void testInvalidCharacterInRoman() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RomanToIntegerConverter.romanToInt("X2I");
        });
        assertEquals("Invalid Roman numeral character: 2", exception.getMessage());
    }

    // 6. Перевірка помилки при великій кількості повторення символів
    @Test
    void testTooManyRepetitionsThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("IIII"));
        assertEquals("Too many repetitions of Roman numeral: I", e.getMessage());
    }

    // 7. Перевірка на наявність від'ємного символу в рядку
    @Test
    void testNegativeSignThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("-X"));
        assertEquals("Invalid Roman numeral character: -", e.getMessage());
    }

    // 8. Перевірка недопустимих повторень символів типу V
    @Test
    void testInvalidRepeatableCharactersThrowsException_V() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("VVV"));
        assertEquals("Invalid repetition of Roman numeral: V", e.getMessage());
    }

    // 9. Перевірка недопустимих повторень символів типу L
    @Test
    void testInvalidRepeatableCharactersThrowsException_L() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("LL"));
        assertEquals("Invalid repetition of Roman numeral: L", e.getMessage());
    }

    // 10. Перевірка недопустимих повторень символів типу D
    @Test
    void testInvalidRepeatableCharactersThrowsException_D() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> converter.romanToInt("DDDDD"));
        assertEquals("Invalid repetition of Roman numeral: D", e.getMessage());
    }
}
