package com.gof.iteration6;

import com.gof.customer.monitors.Monitor;
import com.gof.customer.monitors.MonitorFR;
import com.gof.customer.monitors.MonitorSE;
import com.gof.customer.monitors.MonitorUK;
import com.gof.customer.monitors.MonitorUS;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertSame;

public class Iteration6Test {

    @Test
    public void testRun() {
        Iteration6.run();
    }

    @Test
    public void shouldKeepCertainNumberOfMonitors() throws NoSuchFieldException, IllegalAccessException {
        MsgProcessor msgProcessor = new MsgProcessor();
        Monitor monitor1 = new MonitorFR();
        Monitor monitor2 = new MonitorUK();
        Monitor monitor3 = new MonitorUS();
        Monitor monitor4 = new MonitorSE();

        Stream.of(monitor1, monitor2, monitor3, monitor4)
                .forEach(monitor ->  msgProcessor.registerObserver(monitor));
        msgProcessor.removeObserver(monitor2);

        msgProcessor.notifyObservers();

        Field field = msgProcessor.getClass().getDeclaredField("monitors");
        field.setAccessible(true);
        List<Monitor> monitors = (List<Monitor>)field.get(msgProcessor);

        assertSame(3, monitors.size());
    }
}