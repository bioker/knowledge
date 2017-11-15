package net.wls.learn.spring.events;

import org.springframework.context.ApplicationListener;

public class MyApplicationEventHandler implements ApplicationListener<MyApplicationEvent> {
    @Override
    public void onApplicationEvent(MyApplicationEvent myApplicationEvent) {
        System.out.println(myApplicationEvent);
    }
}
