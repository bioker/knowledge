package net.wls.test.springmvc;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Hello implements Serializable {

    @Getter
    @Setter
    private String message;
}
