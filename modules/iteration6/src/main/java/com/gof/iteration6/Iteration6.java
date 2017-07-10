package com.gof.iteration6;

import com.gof.customer.RemoteOutputAPIAcronis;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;
import com.gof.customer.monitors.MonitorFR;
import com.gof.customer.monitors.MonitorUK;
import com.gof.customer.monitors.MonitorUS;

import java.util.List;

public class Iteration6 {

    public static void run() {

        Channel2 channel2 = new Channel2();
        List<DataAPI> dataAPIList = channel2.getDataAPI();
        MsgProcessor msgProcessor = new MsgProcessor();

        // Create and register subscribers
        msgProcessor.registerObserver(new MonitorFR());
        msgProcessor.registerObserver(new MonitorUK());
        msgProcessor.registerObserver(new MonitorUS());

        dataAPIList.stream()
                .forEach(dataAPI -> {
                    processData(dataAPI);
                    msgProcessor.notifyObservers();
                });
    }

    private static void processData(DataAPI dataAPI) {
        RemoteOutputAPIAcronis.sendFX(dataAPI.getDataFX());
        RemoteOutputAPIAcronis.sendSX(dataAPI.getDataSX());
        RemoteOutputAPIAcronis.sendBX(dataAPI.getDataBX());
        RemoteOutputAPIAcronis.sendFX(dataAPI.getDataFX());
    }

}
