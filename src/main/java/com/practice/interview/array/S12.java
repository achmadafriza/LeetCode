package com.practice.interview.array;

public class S12 {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();

        while (num >= 1000) {
            builder.append('M');
            num -= 1000;
        }

        if (num / 100 == 9) {
            builder.append("CM");
            num -= 900;
        }

        while (num >= 500) {
            builder.append('D');
            num -= 500;
        }

        if (num / 100 == 4) {
            builder.append("CD");
            num -= 400;
        }

        while (num >= 100) {
            builder.append('C');
            num -= 100;
        }

        if (num / 10 == 9) {
            builder.append("XC");
            num -= 90;
        }

        while (num >= 50) {
            builder.append('L');
            num -= 50;
        }

        if (num / 10 == 4) {
            builder.append("XL");
            num -= 40;
        }

        while (num >= 10) {
            builder.append('X');
            num -= 10;
        }

        if (num == 9) {
            builder.append("IX");
            num -= 9;
        }

        while (num >= 5) {
            builder.append('V');
            num -= 5;
        }

        if (num == 4) {
            builder.append("IV");
            num -= 4;
        }

        while (num > 0) {
            builder.append('I');
            num -= 1;
        }

        return builder.toString();
    }
}
