package net.wls.test.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class ConfController {

    @Autowired
    private ConfRepository confRepository;

    @RequestMapping("/")
    public String conf() throws SQLException {
        confRepository.test();
        return "OK";
    }
}
