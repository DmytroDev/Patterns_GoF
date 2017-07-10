package com.gof.iteration6;

import com.gof.customer.monitors.Monitor;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface Observable {
    String message = "Data was successfully processed";

    void registerObserver(Monitor monitor);
    void removeObserver(Monitor monitor);
    void notifyObservers();
}
