package com.gof.iteration5;

import com.gof.customer.RemoteOutputAPIAcronis;
import com.gof.customer.core.DataAPI;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class RemoteOutputAPIAcronisFacade {

    public void setOutputData(DataAPI dataAPI) {
        RemoteOutputAPIAcronis.initSystem();
        RemoteOutputAPIAcronis.preparingConnection();
        RemoteOutputAPIAcronis.connect();
        RemoteOutputAPIAcronis.sendMX(dataAPI.getDataMX());
        RemoteOutputAPIAcronis.sendSX(dataAPI.getDataSX());
        RemoteOutputAPIAcronis.sendBX(dataAPI.getDataBX());
        RemoteOutputAPIAcronis.sendFX(dataAPI.getDataFX());
        RemoteOutputAPIAcronis.stopSystem();
        RemoteOutputAPIAcronis.checkErrors();
        RemoteOutputAPIAcronis.disconnect();
    }

}
