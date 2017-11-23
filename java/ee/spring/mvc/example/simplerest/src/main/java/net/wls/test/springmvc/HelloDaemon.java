package net.wls.test.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloDaemon {

    @Autowired
    private Daemon testDaemon;

    @RequestMapping(value = "/daemon/{command}", method = RequestMethod.PUT)
    @ResponseBody
    public String command(@PathVariable String command) {
        switch (command) {
            case "start": {
                testDaemon.start();
                return "Started";
            }
            case "stop": {
                testDaemon.stop();
                return "Stopped";
            }
            default: {
                return "Invalid Command";
            }
        }
    }
}
