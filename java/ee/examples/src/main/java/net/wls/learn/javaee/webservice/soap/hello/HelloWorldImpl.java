package net.wls.learn.javaee.webservice.soap.hello;

import javax.jws.WebService;

@WebService(endpointInterface = "net.wls.learn.javaee.webservice.soap.hello.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello Web Service World by " + name;
    }
}