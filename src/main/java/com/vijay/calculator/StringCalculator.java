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

        int flag = 0;
        String errorMessage = "negatives not allowed:";
        for (int i = 0; i < number.length; i++) {
        	if (number[i].charAt(0) == '-') {
				errorMessage += " " + number[i];
				flag = 1;
			}
		}

        if (flag == 1) {
        	throw new Exception(errorMessage);
		}

		sum = Arrays.stream(number).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}
