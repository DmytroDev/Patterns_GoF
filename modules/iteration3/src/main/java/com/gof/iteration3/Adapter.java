package com.gof.iteration3;

import com.gof.customer.core.DataAPI;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class Adapter {

    private DataAPI dataAPI;

    public Adapter(DataAPI dataAPI) {
        this.dataAPI = dataAPI;
    }

    public DataAPI processData() {
        String result = this.dataAPI.getDataFX()
                + this.dataAPI.getDataMX()
                + this.dataAPI.getDataSX()
                + this.dataAPI.getDataBX();
        this.dataAPI.setResultX(result);

        return this.dataAPI;
    }

}
