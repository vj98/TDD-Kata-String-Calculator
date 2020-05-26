package com.vijay.test;

import com.vijay.calculator.StringCalculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Order(1)
    @DisplayName("testAddWithEmpty method")
    @Test
    public void testAddWithEmptyNumber() throws Exception {
        String param = "";
        Integer result = stringCalculator.Add(param);
        assertEquals(0, result);
    }

    @Order(2)
    @DisplayName("testAddWithOneNumber method")
    @Test
    public void testAddWithOneNumber() throws Exception {
        String param = "1";
        Integer result = stringCalculator.Add(param);

        assertEquals(1, result);
    }

    @Order(3)
    @DisplayName("testAddWithTwoNumber method")
    @Test
    public void testAddWithTwoNumber() throws Exception {
        String param = "1,2";
        Integer result = stringCalculator.Add(param);

        assertEquals(3, result);
    }

    @Order(4)
    @DisplayName("testAddWithUnknownNumber method")
    @Test
    public void testAddWithUnknownNumber() throws Exception {
        String param = "1,2,3,4,10";
        Integer result = stringCalculator.Add(param);

        assertEquals(20, result);
    }

    @Order(5)
    @DisplayName("testAddSupportNewLineSeparator method")
    @Test
    public void testAddSupportNewLineSeparator() throws Exception {
        String param = "1,2\n3,4\n10";
        Integer result = stringCalculator.Add(param);
        assertEquals(20, result);
    }

    @Order(6)
    @DisplayName("testAddBeginWithDelimiters method")
    @Test
    public void testAddBeginWithDelimiters() throws Exception {
        String param = "//[;]\n1;2;3;4;10";
        Integer result = stringCalculator.Add(param);

        assertEquals(20, result);
    }

    @Order(7)
    @DisplayName("testAddOneNegativeNumberException method")
    @Test
    public void testAddOneNegativeNumberException() throws Exception {
        String param = "-1";

        Throwable exception = assertThrows(Exception.class, () -> {
            stringCalculator.Add(param);
        });

        assertEquals("negatives not allowed: -1", exception.getMessage());
    }

    @Order(8)
    @DisplayName("testAddMultipleNegativeNumberException method")
    @Test
    public void testAddMultipleNegativeNumberException() throws Exception {
        String param = "-1,-2,-4";

        Throwable exception = assertThrows(Exception.class, () -> {
            stringCalculator.Add(param);
        });

        assertEquals("negatives not allowed: -1 -2 -4", exception.getMessage());
    }

    @Order(9)
    @DisplayName("testAddNumberOfTimeInvoke method")
    @Test
    public void testAddNumberOfTimeInvoke() throws Exception {
        String param = "1,2,4";
        Integer result = stringCalculator.Add(param);

        assertEquals(7, result);
        assertEquals(9, stringCalculator.GetCalledCount());
    }

    @Order(10)
    @DisplayName("testAddIgnoreGreaterThanThousand method")
    @Test
    public void testAddIgnoreGreaterThanThousand() throws Exception {
        String param = "1,2,4,1000,1001";
        Integer result = stringCalculator.Add(param);

        assertEquals(1007, result);
    }
}
