package com.gof.iteration8;

import com.gof.customer.core.DataAPI;

import static com.gof.iteration8.RegexUtils.PATTERN_CHARS;
import static com.gof.iteration8.RegexUtils.PATTERN_NUMBERS;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class DataCBuilder {

    private DataAPI dataAPI;

    public DataCBuilder(long id) {
        this.dataAPI = new DataAPI(id);
    }

    public DataCBuilder setDataMX(String dataMX) {
        if (!PATTERN_NUMBERS.matcher(dataMX).matches()) {
            throw new IllegalArgumentException("Wrong input parameter");
        }
        this.dataAPI.setDataMX(dataMX);
        return this;
    }

    public DataCBuilder setDataSX(String dataSX) {
        if (!PATTERN_CHARS.matcher(dataSX).matches()) {
            throw new IllegalArgumentException("Wrong input parameter");
        }
        this.dataAPI.setDataSX(dataSX);
        return this;
    }

    public DataCBuilder setDataFX(String dataFX) {
        if (!PATTERN_CHARS.matcher(dataFX).matches()) {
            throw new IllegalArgumentException("Wrong input parameter");
        }
        this.dataAPI.setDataFX(dataFX);
        return this;
    }

    public DataCBuilder setDataBX(String dataBX) {
        if (!PATTERN_NUMBERS.matcher(dataBX).matches()) {
            throw new IllegalArgumentException("Wrong input parameter");
        }
        this.dataAPI.setDataBX(dataBX);
        return this;
    }

    public DataAPI build() {
        return this.dataAPI;
    }

}
