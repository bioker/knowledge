package net.wls.test.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello() {
        String message = "Hello World!";
        return new ModelAndView("hello", "message", message);
    }
}
