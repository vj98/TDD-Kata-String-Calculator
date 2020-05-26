package com.vijay.calculator;

public class StringCalculator {
	public int Add(String numbers) {
		if (numbers.length() == 0) {
			return 0;
		}

		String[] number = numbers.split(",");

		if (number.length == 1) {
			return Integer.parseInt(number[0]);
		}

		return Integer.parseInt(number[0]) + Integer.parseInt(number[1]);
	}
}
