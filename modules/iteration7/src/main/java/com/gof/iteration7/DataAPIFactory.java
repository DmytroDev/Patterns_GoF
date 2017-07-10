package com.gof.iteration7;

import com.gof.customer.core.DataAPI;
import com.gof.customer.data.TypeOfData;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static com.gof.iteration7.DataGeneratorUtils.CHARS;
import static com.gof.iteration7.DataGeneratorUtils.NUMBERS;
import static com.gof.iteration7.DataGeneratorUtils.generateData;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class DataAPIFactory {

    private static final AtomicInteger counter = new AtomicInteger();

    public DataAPI createLightDataAPI() {
        int randomNum = ThreadLocalRandom.current().nextInt(4);
        return new DataAPI(nextValue(), generateData(CHARS), TypeOfData.getValueByOrdinal(randomNum));
    }

    public DataAPI createHeavyDataAPI() {
        int randomNum = ThreadLocalRandom.current().nextInt(4);
        return new DataAPI(nextValue(), TypeOfData.getValueByOrdinal(randomNum), generateData(NUMBERS),
                generateData(NUMBERS), generateData(NUMBERS), generateData(NUMBERS));
    }

    private static long nextValue() {
        return (long)counter.getAndIncrement();
    }
}
