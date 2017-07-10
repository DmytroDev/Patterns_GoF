package com.gof.iteration7;

import java.util.Random;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class DataGeneratorUtils {

    public static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    private static final int CAPACITY = 10;

    @SuppressWarnings("duplicate")
    public static String generateData(String chars) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int dataLength = random.nextInt(CAPACITY);
        while (sb.length() <= dataLength) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
