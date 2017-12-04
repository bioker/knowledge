package net.wls.test.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MessagesProvider messagesProvider;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("messageProvider", messagesProvider);
        return "home";
    }
}
