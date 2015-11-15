package ru.samples.itis.loaders.app;

import com.squareup.otto.Bus;

/**
 * @author Artur Vasilov
 */
public enum Otto {

    INSTANCE,
    ;

    private final Bus mBus;

    Otto() {
        mBus = new Bus();
    }

    public void register(Object object) {
        mBus.register(object);
    }

    public void unregister(Object object) {
        mBus.unregister(object);
    }

    public void post(Object event) {
        mBus.post(event);
    }
}


