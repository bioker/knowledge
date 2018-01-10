package net.wls.test.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public @ResponseBody Hello hello() {
        Hello hello = new Hello();
        hello.setMessage("Hello World!");
        return hello;
    }
}
