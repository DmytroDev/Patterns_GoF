package com.gof.iteration5;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;

import java.util.List;

public class Iteration5 {

    public static void run() {
        List<DataAPI> dataAPIList = new Channel2().getDataAPI();
        RemoteOutputAPI outputAPI = new RemoteOutputAPI();

        dataAPIList.stream()
                .forEach(dataAPI -> {
                    new RemoteOutputAPIAcronisFacade().setOutputData(dataAPI);
                    outputAPI.setOutputData(dataAPI);
                });
    }

}