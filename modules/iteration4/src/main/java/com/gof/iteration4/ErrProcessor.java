package com.gof.iteration4;

import com.gof.customer.core.DataAPI;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class ErrProcessor implements Processor {
    private final String REPLACEMENT = "ER";

    @Override
    public void processData(DataAPI data) {
        process(data, REPLACEMENT);
    }
}
