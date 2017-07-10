package com.gof.iteration1;

import com.gof.customer.RemoteOutputAPI;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Iteration1Test  {

    @Test
    public void testRun() {
        Iteration1.run();

        RemoteOutputAPI outputAPI1 = Iteration1.getRemoteOutputAPIInstance();
        RemoteOutputAPI outputAPI2 = Iteration1.getRemoteOutputAPIInstance();
        assertEquals("Instances of outputAPIs are not identical! ", outputAPI1, outputAPI2);
    }
}