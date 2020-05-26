package com.vijay.main;

import com.vijay.calculator.StringCalculator;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			StringCalculator cal = new StringCalculator();

			System.out.println(cal.Add("123"));
		} catch (Exception e) {
			throw e;
		}
	}
}
