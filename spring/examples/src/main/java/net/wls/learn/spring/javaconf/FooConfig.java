package net.wls.learn.spring.javaconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Foo foo() {
        return new Foo();
    }
}
