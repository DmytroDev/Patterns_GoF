package com.gof.iteration8;

import com.gof.customer.core.DataAPI;

import static com.gof.iteration8.RegexUtils.PATTERN_CHARS;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class DataABuilder {

    private DataAPI dataAPI;

    public DataABuilder(long id) {
        dataAPI = new DataAPI(id);
    }

    public DataABuilder setDataMX(String dataMX) {
        if (!PATTERN_CHARS.matcher(dataMX).matches()) {
            throw new IllegalArgumentException("Wrong input data");
        }
        this.dataAPI.setDataFX(dataMX);
        return this;
    }

    public DataABuilder setDataSX(String dataSX) {
        if (!PATTERN_CHARS.matcher(dataSX).matches()) {
            throw  new IllegalArgumentException("Wrong input data");
        }
        this.dataAPI.setDataSX(dataSX);
        return this;
    }

    public DataAPI build() {
        return this.dataAPI;
    }

}
