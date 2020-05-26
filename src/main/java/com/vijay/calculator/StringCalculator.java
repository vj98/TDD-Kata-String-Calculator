package com.vijay.calculator;

import java.util.Arrays;
import java.util.regex.*;

public class StringCalculator {

	private static int countAddMethodOccurence = 0;

	/**
	 * This method returns number of times Add() method invoked
	 * @return int
	 */
	public int GetCalledCount() {
		return countAddMethodOccurence;
	}

	/**
	 * Parses the integer from the string from the delimiters and return sum of the integer.
	 * In case of negative numbers returns exception.
	 * @param numbers
	 * @return int
	 * @throws Exception
	 */
    public int Add(String numbers) throws Exception {
		++countAddMethodOccurence;
        if (numbers.length() == 0) {
            return 0;
        }

        int sum = 0;
		String[] number = null;
		String temp = null;

		Pattern p = Pattern.compile("(//\\[(.+)\\]\n).*");
		Matcher m = p.matcher(numbers);

        if (m.matches()) {
			String sub = m.group(1);
			numbers = numbers.replace(sub, "");
			String delimiter = m.group(2);
			if (delimiter.charAt(0) == '*') {
				numbers = numbers.replace(delimiter, "#");
				number = numbers.split("#");
			}
			else {
				number = numbers.split(delimiter);
			}
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

		sum = Arrays.stream(number).mapToInt(Integer::parseInt).filter(x -> x <= 1000).sum();
        return sum;
    }
}
