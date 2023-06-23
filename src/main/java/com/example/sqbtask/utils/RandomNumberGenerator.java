package com.example.sqbtask.utils;

import java.util.Random;

public class RandomNumberGenerator {
    public static String generateLimit() {
        int length = 8;

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int firstDigit = random.nextInt(8) + 1;
        sb.append(firstDigit);

        for (int i = 1; i < length; i++) {
            int digit = random.nextInt(8);
            sb.append(digit);
        }

        return sb.toString();
    }
}
