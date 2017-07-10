package com.gof.iteration7;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;

import java.util.stream.Stream;

public class Iteration7 {

    public static void run(){
        DataAPIFactory apiFactory = new DataAPIFactory();

        DataAPI apiLight1 = apiFactory.createLightDataAPI();
        DataAPI apiLight2 = apiFactory.createLightDataAPI();

        DataAPI apiHeavy1 = apiFactory.createHeavyDataAPI();
        DataAPI apiHeavy2 = apiFactory.createHeavyDataAPI();

        RemoteOutputAPITesting outputAPITesting = new RemoteOutputAPITesting();
        Stream.of(apiLight1, apiLight2, apiHeavy1, apiHeavy2)
                .forEach(dataAPI -> outputAPITesting.setOutputData(dataAPI));
    }

}