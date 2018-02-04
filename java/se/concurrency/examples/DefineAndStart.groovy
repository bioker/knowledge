#!/usr/bin/env groovy
public class HelloRunnable implements Runnable {
    
    @Override
    public void run(){
        System.out.println("Hello from a thread!");
    }
    
}

public class HelloThread extends Thread {

    @Override
    public void run(){
        System.out.println("Hello from a thread!");
    }

}

new HelloThread().start();
new Thread(new HelloRunnable()).start();
