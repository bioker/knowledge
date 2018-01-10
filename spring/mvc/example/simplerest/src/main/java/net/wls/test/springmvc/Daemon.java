package net.wls.test.springmvc;

import java.util.concurrent.CompletableFuture;

public interface Daemon {
    CompletableFuture<String> start();

    void stop();
}
