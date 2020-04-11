package org.stefataa.leetcodesubmissions.medium;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman subject = new IntegerToRoman();
        System.out.println(subject.intToRoman(20));
        System.out.println(subject.intToRoman(13));
        System.out.println(subject.intToRoman(1));
        System.out.println(subject.intToRoman(3));
        System.out.println(subject.intToRoman(4));
        System.out.println(subject.intToRoman(9));
        System.out.println(subject.intToRoman(58));
        System.out.println(subject.intToRoman(1994));
    }

    static Map<Integer, String> symbolByValue = new TreeMap<>(Comparator.reverseOrder());

    static {
        symbolByValue.put(1, "I");
        symbolByValue.put(5, "V");
        symbolByValue.put(10, "X");
        symbolByValue.put(50, "L");
        symbolByValue.put(100, "C");
        symbolByValue.put(500, "D");
        symbolByValue.put(1000, "M");
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int temp = num;
        int base = 1;
        while (temp > 0) {
            int remainder = (temp % 10) * base;
            if (remainder != 0) {
                result.insert(0, getRomanFromNumberDivisibleByValues(remainder));
            }
            temp /= 10;
            base *= 10;
        }

        return result.toString();
    }

    public String getRomanFromNumberDivisibleByValues(int num) {
        for (Integer value : symbolByValue.keySet()) {
            if (value == num) {
                return symbolByValue.get(value);
            }
            //special cases
            if (value - 1 == num) {
                return "I" + symbolByValue.get(value);
            }
            if (value - 10 == num) {
                return "X" + symbolByValue.get(value);
            }
            if (value - 100 == num) {
                return "C" + symbolByValue.get(value);
            }
            if (num / value == 0) {
                continue;
            }
            return symbolByValue.get(value) + getRomanFromNumberDivisibleByValues(num - value);
        }
        throw new IllegalStateException("Should not come here");
    }

}
