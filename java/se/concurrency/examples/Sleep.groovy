#!/usr/bin/env groovy
public class HelloSleep implements Runnable {
    
    @Override
    public void run(){
        try {
            for (String message : ["one", "two", "three"]){
                Thread.sleep(1000);
                System.out.println(message);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
}

new Thread(new HelloSleep()).start();
