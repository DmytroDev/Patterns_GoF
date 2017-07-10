package com.gof.iteration2;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel1;
import com.gof.customer.core.DataAPI;

import java.util.List;

import static com.gof.iteration2.StringUtils.ERR;
import static com.gof.iteration2.StringUtils.FAKE;
import static com.gof.iteration2.StringUtils.FOUR;
import static com.gof.iteration2.StringUtils.LIVE;
import static com.gof.iteration2.StringUtils.ONE;
import static com.gof.iteration2.StringUtils.PREPARED;
import static com.gof.iteration2.StringUtils.TREE;
import static com.gof.iteration2.StringUtils.TWO;

public class Iteration2 {

    private static RemoteOutputAPI outputAPI = new RemoteOutputAPI();

    public static void run() {
        Processor liveProcessor = new LiveProcessor();
        Processor preparedProcessor = new PreparedProcessor();
        Processor fakeProcessor = new FakeProcessor();
        Processor errProcessor = new ErrProcessor();

        liveProcessor.setNextChain(preparedProcessor);
        preparedProcessor.setNextChain(fakeProcessor);
        fakeProcessor.setNextChain(errProcessor);

        Channel1 channel1 = new Channel1();
        List<DataAPI> dataAPIList = channel1.getDataAPI();
        dataAPIList.stream().forEach(dataAPI -> liveProcessor.processData(dataAPI));
    }

    public static abstract class Processor {
        // depends on api.getTypeOfData() it will processing specific processor.
        Processor processor;

        void setNextChain(Processor nextChain) {
            this.processor = nextChain;
        }

        abstract void processData(DataAPI data);

        void doProcessData(DataAPI data, String typeOfData, String suffix) {
            if (data.getTypeOfData().name().equals(typeOfData)) {
                System.out.println(this.getClass().getSimpleName() + " run ...");
                modifyField(data, suffix);
                outputAPI.setOutputData(data);
            } else {
                this.processor.processData(data);
            }
        }
    }

    public static class LiveProcessor extends Processor {

        @Override
        void processData(DataAPI data) {
            doProcessData(data, LIVE, ONE);
        }
    }

    public static class PreparedProcessor extends Processor {

        @Override
        void processData(DataAPI data) {
            doProcessData(data, PREPARED, TWO);
        }
    }

    public static class FakeProcessor extends Processor {

        @Override
        void processData(DataAPI data) {
            doProcessData(data, FAKE, TREE);
        }
    }

    public static class ErrProcessor extends Processor {

        @Override
        void processData(DataAPI data) {
            doProcessData(data, ERR, FOUR);
        }
    }

    private static void modifyField(DataAPI api, String suffix) {
        api.setDataFX(api.getDataFX() + suffix);
    }
}