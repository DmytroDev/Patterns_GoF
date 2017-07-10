package com.gof.iteration2;

import com.gof.customer.core.Channel1;
import com.gof.customer.core.DataAPI;
import org.junit.Test;

import java.util.List;

import static com.gof.iteration2.StringUtils.ERR;
import static com.gof.iteration2.StringUtils.FAKE;
import static com.gof.iteration2.StringUtils.LIVE;
import static com.gof.iteration2.StringUtils.PREPARED;
import static junit.framework.TestCase.assertEquals;


public class Iteration2Test {

    @Test
    public void testRun() {
        Iteration2.run();
    }

    @Test
    public void amountShouldBeTheSame() {
        Iteration2.Processor liveProcessor = new Iteration2.LiveProcessor();
        Iteration2.Processor preparedProcessor = new Iteration2.PreparedProcessor();
        Iteration2.Processor fakeProcessor = new Iteration2.FakeProcessor();
        Iteration2.Processor errProcessor = new Iteration2.ErrProcessor();

        liveProcessor.setNextChain(preparedProcessor);
        preparedProcessor.setNextChain(fakeProcessor);
        fakeProcessor.setNextChain(errProcessor);

        Channel1 channel1 = new Channel1();
        List<DataAPI> dataAPIList = channel1.getDataAPI();
        long liveCounter = calculate(dataAPIList, LIVE) * 1;
        long preparedCounter = calculate(dataAPIList, PREPARED) * 2;
        long fakeCounter = calculate(dataAPIList, FAKE) * 3;
        long errCounter = calculate(dataAPIList, ERR) * 4;
        long totalInputCounter = liveCounter + preparedCounter + fakeCounter + errCounter;

        dataAPIList.stream().forEach(dataAPI -> liveProcessor.processData(dataAPI));

        int totalOutputCounter = dataAPIList.stream()
                .mapToInt(dataAPI -> Character.getNumericValue(dataAPI.getDataFX().charAt(dataAPI.getDataFX().length() - 1)))
                .sum();
        assertEquals(totalInputCounter, totalOutputCounter);
    }

    private long calculate(List<DataAPI> dataAPIList, String dataType) {
        return dataAPIList.stream()
                .filter(dataAPI -> dataAPI.getTypeOfData().name().equals(dataType))
                .count();
    }

}