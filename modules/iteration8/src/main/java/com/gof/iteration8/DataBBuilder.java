package com.gof.iteration8;

import com.gof.customer.core.DataAPI;

import static com.gof.iteration8.RegexUtils.PATTERN_CHARS;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class DataBBuilder {
    private DataAPI dataAPI;

    public DataBBuilder(long id) {
        this.dataAPI = new DataAPI(id);
    }

    public DataBBuilder setDataFX(String dataFX) {
        if(!PATTERN_CHARS.matcher(dataFX).matches()) {
            throw new IllegalArgumentException("Wrong input parameter");
        }
        this.dataAPI.setDataFX(dataFX);
        return this;
    }

    public DataBBuilder setDataBX(String dataBX) {
        if (!PATTERN_CHARS.matcher(dataBX).matches()) {
            throw new IllegalArgumentException("Wrong input parameter");
        }
        this.dataAPI.setDataBX(dataBX);
        return this;
    }

    public DataAPI build() {
        return this.dataAPI;
    }

}
