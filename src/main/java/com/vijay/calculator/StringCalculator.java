package com.vijay.calculator;

import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        String[] number = numbers.split(",");
        Integer sum = 0;

        sum = Arrays.stream(number).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}
