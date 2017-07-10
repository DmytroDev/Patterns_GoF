package com.gof.iteration8;

import com.gof.customer.core.DataAPI;
import org.junit.Test;

import static com.gof.iteration8.Iteration8.CHARS;
import static com.gof.iteration8.Iteration8.NUMBERS;
import static com.gof.iteration8.Iteration8.generateData;
import static junit.framework.TestCase.assertTrue;

public class Iteration8Test {

    @Test
    public void testRun() {
        Iteration8.run();
    }

    @Test
    public void testBuilder() {
        DataAPI dataAPI = new DataCBuilder(1L)
                .setDataMX(generateData(NUMBERS))
                .setDataSX(generateData(CHARS))
                .setDataFX(generateData(CHARS))
                .setDataBX(generateData(NUMBERS))
                .build();

        assertTrue(dataAPI != null);
        assertTrue(!dataAPI.getDataMX().isEmpty());
        assertTrue(!dataAPI.getDataSX().isEmpty());
        assertTrue(!dataAPI.getDataFX().isEmpty());
        assertTrue(!dataAPI.getDataBX().isEmpty());
    }
}