package net.wls.test.springmvc;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Component
public class TestDaemon implements Daemon {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss_S");
    private static final long workTime = 10000;
    private static final int step = 1000;

    private boolean stop = false;

    @Override
    @Async
    public CompletableFuture<String> start() {
        long startTime = System.currentTimeMillis();
        System.out.println("Start time: " + sdf.format(new Date()));
        while ((System.currentTimeMillis() - startTime) < workTime) {
            if (stop) {
                System.out.println("Stop time: " + sdf.format(new Date()));
                return CompletableFuture.completedFuture("Stopped");
            }
            try {
                Thread.sleep(step);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("End time: " + sdf.format(new Date()));
        return CompletableFuture.completedFuture("Complete");
    }

    @Override
    public void stop() {
        System.out.println("Stop signal");
        stop = true;
    }
}
