package com.gof.iteration4;

import com.gof.customer.data.TypeOfData;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class Factory {

    Processor createProcessor(TypeOfData typeOfData) {

        switch (typeOfData) {
            case LIVE:
                return new LiveProcessor();
            case PREPARED:
                return new PreparedProcessor();
            case FAKE:
                return new FakeProcessor();
            case ERR:
                return new ErrProcessor();
            default:
                throw new IllegalArgumentException("Unsupported data type " + String.valueOf(typeOfData));
        }
    }

}
