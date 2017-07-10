package com.gof.iteration4;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;

import java.util.List;

public class Iteration4 {

    public static void run() {

        Channel2 channel2 = new Channel2();
        List<DataAPI> dataAPIList = channel2.getDataAPI();
        RemoteOutputAPI outputAPI = new RemoteOutputAPI();

        dataAPIList.stream()
                .forEach(dataAPI -> {
                            new Factory()
                                    .createProcessor(dataAPI.getTypeOfData())
                                    .processData(dataAPI);
                            outputAPI.setOutputData(dataAPI);
                        }
                );
    }

}