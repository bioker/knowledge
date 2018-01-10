package net.wls.learn.spring.events;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {
    public MyApplicationEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "MyApplicationEvent{}";
    }
}
