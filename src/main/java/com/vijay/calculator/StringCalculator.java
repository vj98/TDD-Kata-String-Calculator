package com.vijay.calculator;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers) throws Exception {
        if (numbers.length() == 0) {
            return 0;
        }

        int sum = 0;
		String[] number = null;
		String temp = null;

        if (numbers.startsWith("//")) {
			String delimiter = numbers.substring(2, 3);
			temp = numbers.substring(4);
			number = temp.split("["+delimiter+"\n"+"]");
		}
        else {
			number = numbers.split("[,\n]");
		}

        for (int i = 0; i < number.length; i++) {
        	if (number[i].charAt(0) == '-') {
				throw new Exception("negatives not allowed: " + number[i]);
			}
		}

		sum = Arrays.stream(number).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}
