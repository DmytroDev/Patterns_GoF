package com.gof.iteration3;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class Iteration3Test {

    @Test
    public void testRun() {
        Iteration3.run();
    }

    @Test
    public void shouldConcatData() {

        Channel2 channel2 = new Channel2();
        List<DataAPI> dataAPIList = channel2.getDataAPI();
        List<String> concatDataListBeforeProcessing = dataAPIList.stream()
                .map(dataAPI ->
                        dataAPI.getDataFX()
                        + dataAPI.getDataMX()
                        + dataAPI.getDataSX()
                        + dataAPI.getDataBX())
                .collect(Collectors.toList());

        RemoteOutputAPI outputAPI = new RemoteOutputAPI();

        dataAPIList.stream()
                .forEach(dataAPI -> {
                    new Adapter(dataAPI).processData();
                    outputAPI.setOutputData(dataAPI);
                });

        List<String> resultList = dataAPIList.stream()
                .map(DataAPI::getResultX)
                .collect(Collectors.toList());
        assertEquals(concatDataListBeforeProcessing, resultList);
    }
}