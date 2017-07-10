package com.gof.iteration4;

import com.gof.customer.data.TypeOfData;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Iteration4Test {

    @Test
    public void testRun() {
        Iteration4.run();
    }

    @Test
    public void shouldReturnSpecificProcessor() {
        Factory factory = new Factory();
        Processor processor1 = factory.createProcessor(TypeOfData.LIVE);
        Processor processor2 = factory.createProcessor(TypeOfData.PREPARED);
        Processor processor3 = factory.createProcessor(TypeOfData.FAKE);
        Processor processor4 = factory.createProcessor(TypeOfData.ERR);

        assertTrue(processor1 instanceof LiveProcessor);
        assertTrue(processor2 instanceof PreparedProcessor);
        assertTrue(processor3 instanceof FakeProcessor);
        assertTrue(processor4 instanceof ErrProcessor);

    }
}