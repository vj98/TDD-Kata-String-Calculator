package com.vijay.test;

import com.vijay.calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("testAddWithEmpty method")
    @Test
    public void testAddWithEmptyNumber() throws Exception {
        String param = "";
        Integer result = stringCalculator.Add(param);
        assertEquals(0, result);
    }

    @DisplayName("testAddWithOneNumber method")
    @Test
    public void testAddWithOneNumber() throws Exception {
        String param = "1";
        Integer result = stringCalculator.Add(param);

        assertEquals(1, result);
    }

    @DisplayName("testAddWithTwoNumber method")
    @Test
    public void testAddWithTwoNumber() throws Exception {
        String param = "1,2";
        Integer result = stringCalculator.Add(param);

        assertEquals(3, result);
    }

    @DisplayName("testAddWithUnknownNumber method")
    @Test
    public void testAddWithUnknownNumber() throws Exception {
        String param = "1,2,3,4,10";
        Integer result = stringCalculator.Add(param);

        assertEquals(20, result);
    }

    @DisplayName("testAddSupportNewLineSeparator method")
    @Test
    public void testAddSupportNewLineSeparator() throws Exception {
        String param = "1,2\n3,4\n10";
        Integer result = stringCalculator.Add(param);

        assertEquals(20, result);
    }

    @DisplayName("testAddBeginWithDelimiters method")
    @Test
    public void testAddBeginWithDelimiters() throws Exception {
        String param = "//;\n1;2\n3;4\n10";
        Integer result = stringCalculator.Add(param);

        assertEquals(20, result);
    }

    @DisplayName("testAddOneNegativeNumberException method")
    @Test
    public void testAddOneNegativeNumberException() throws Exception {
        String param = "-1";

        Throwable exception = assertThrows(Exception.class, () -> {
            stringCalculator.Add(param);
        });

        assertEquals("negatives not allowed: -1", exception.getMessage());
    }

    @DisplayName("testAddMultipleNegativeNumberException method")
    @Test
    public void testAddMultipleNegativeNumberException() throws Exception {
        String param = "-1,-2,-4";

        Throwable exception = assertThrows(Exception.class, () -> {
            stringCalculator.Add(param);
        });

        assertEquals("negatives not allowed: -1 -2 -4", exception.getMessage());
    }
}
