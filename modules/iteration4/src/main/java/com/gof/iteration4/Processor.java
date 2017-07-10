package com.gof.iteration4;

import com.gof.customer.core.DataAPI;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface Processor {
    String TARGET = "0";

    void processData(DataAPI data);

    default void process(DataAPI data, String replacement) {
        String result = data.getDataMX().replace(TARGET, replacement)
                + data.getDataSX().replace(TARGET, replacement)
                + data.getDataBX().replace(TARGET, replacement)
                + data.getDataFX().replace(TARGET, replacement);
        data.setDataFX(result);
    }
}
