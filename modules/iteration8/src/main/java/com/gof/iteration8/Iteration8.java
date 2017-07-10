package com.gof.iteration8;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;

import java.util.Random;

public class Iteration8 {

    public static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    private static final int CAPACITY = 10;

    public static void run() {

        DataAPI dataA = new DataABuilder(1L)
                .setDataMX(generateData(CHARS))
                .setDataSX(generateData(CHARS))
                .build();

        DataAPI dataB = new DataBBuilder(2L)
                .setDataFX(generateData(CHARS))
                .setDataBX(generateData(CHARS))
                .build();

        DataAPI dataC = new DataCBuilder(3L)
                .setDataMX(generateData(NUMBERS))
                .setDataSX(generateData(CHARS))
                .setDataFX(generateData(CHARS))
                .setDataBX(generateData(NUMBERS))
                .build();

        RemoteOutputAPITesting remoteAPITesting = new RemoteOutputAPITesting();
        remoteAPITesting.setOutputData(dataA);
        remoteAPITesting.setOutputData(dataB);
        remoteAPITesting.setOutputData(dataC);
    }

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