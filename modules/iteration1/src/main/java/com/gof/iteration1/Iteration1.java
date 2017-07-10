package com.gof.iteration1;

import com.gof.customer.RemoteInputAPI;
import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.DataAPI;

public class Iteration1 {

    private static final RemoteInputAPI RM_IN = new RemoteInputAPI();
    private static RemoteOutputAPI RM_OUT;

    public static void run() {
        DataAPI dataAPI = RM_IN.getInputData();
        getRemoteOutputAPIInstance().setOutputData(dataAPI.getId(), dataAPI.getDataFX());
    }

    public static synchronized RemoteOutputAPI getRemoteOutputAPIInstance(){
        if(RM_OUT == null) {
            RM_OUT = new RemoteOutputAPI();
        }
        return RM_OUT;
    }
}
