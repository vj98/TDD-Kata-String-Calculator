package com.vijay.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static int countAddMethodOccurence = 0;

    /**
     * This method returns number of times Add() method invoked
     *
     * @return int
     */
    public int GetCalledCount() {
        return countAddMethodOccurence;
    }

    /**
     * Parses the integer from the string from the delimiters and return sum of the integer.
     * In case of negative numbers returns exception.
     *
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

        Pattern q = Pattern.compile("(//\\[(.+)\\]\\[(.+)\\]\n).*");
        Matcher n = q.matcher(numbers);

        if (n.matches()) {
            numbers = numbers.replace(n.group(1), "").replace(n.group(2), "#").replace(n.group(3), "#");
            number = numbers.split("#");
        } else if (m.matches()) {
            numbers = numbers.replace(m.group(1), "").replace(m.group(2), "#");
            number = numbers.split("#");
        } else {
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
