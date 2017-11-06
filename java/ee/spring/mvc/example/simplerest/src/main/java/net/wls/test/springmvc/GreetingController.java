package net.wls.test.springmvc;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public @ResponseBody Hello hello(@PathVariable String name) {
        Hello hello = new Hello();
        hello.setMessage("Hello " + name + "!");
        return hello;
    }
}
