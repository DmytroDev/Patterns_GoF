package com.gof.iteration6;

import com.gof.customer.monitors.Monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class MsgProcessor implements Observable {
    private List<Monitor> monitors;

    MsgProcessor() {
        this.monitors = new ArrayList<>();
    }

    @Override
    public void registerObserver(Monitor monitor) {
        this.monitors.add(monitor);
    }

    @Override
    public void removeObserver(Monitor monitor) {
        this.monitors.remove(monitor);
    }

    @Override
    public void notifyObservers() {
        this.monitors.stream()
                .forEach(monitor -> monitor.showMessage(message));
    }
}
