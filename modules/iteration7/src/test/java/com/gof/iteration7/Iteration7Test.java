package com.gof.iteration7;

import com.gof.customer.core.DataAPI;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.gof.iteration7.DataGeneratorUtils.CHARS;
import static com.gof.iteration7.DataGeneratorUtils.NUMBERS;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Iteration7Test {

    private static DataAPIFactory apiFactory;
    private static String CHARS_REGEX = "[a-zA-Z]+";
    private static String NUMBERS_REGEX = "[0-9]+";

    @BeforeClass
    public static void init() {
        apiFactory = new DataAPIFactory();
    }

    @Test
    public void testRun() {
        Iteration7.run();
    }

    @Test
    public void shouldCreateLightApiInstance() {
        DataAPI lightDataAPI = apiFactory.createLightDataAPI();
        assertTrue(lightDataAPI != null);
        assertFalse(lightDataAPI.getDataFX().isEmpty());
    }

    @Test
    public void shouldCreateHeavyApiInstance() {
        DataAPI heavyDataAPI = apiFactory.createHeavyDataAPI();
        assertTrue(heavyDataAPI != null);
        assertFalse(heavyDataAPI.getDataFX().isEmpty());
        assertFalse(heavyDataAPI.getDataMX().isEmpty());
        assertFalse(heavyDataAPI.getDataSX().isEmpty());
        assertFalse(heavyDataAPI.getDataBX().isEmpty());
    }

    @Test
    public void shouldGenerateSpecificData() {
        String chars = DataGeneratorUtils.generateData(CHARS);
        String numbers = DataGeneratorUtils.generateData(NUMBERS);

        assertTrue(chars.matches(CHARS_REGEX));
        assertTrue(numbers.matches(NUMBERS_REGEX));
    }

}