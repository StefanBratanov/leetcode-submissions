package org.stefataa.leetcodesubmissions.easy;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger subject = new ReverseInteger();
        System.out.println(subject.reverse(123));
        System.out.println(subject.reverse(-123));
        System.out.println(subject.reverse(120));
        System.out.println(subject.reverse(0));
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int temp = Math.abs(x);
        int result = 0;
        while (temp > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int remainder = temp % 10;
            result = result * 10 + remainder;
            temp /= 10;
        }

        return x < 0 ? result * -1 : result;
    }
}
