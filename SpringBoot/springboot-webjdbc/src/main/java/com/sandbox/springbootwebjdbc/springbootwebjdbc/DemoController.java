package com.sandbox.springbootwebjdbc.springbootwebjdbc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    static final Logger logger = LogManager.getLogger(DemoController.class.getName());

    @RequestMapping(method = RequestMethod.GET, value = "/hello",
            produces = "text/plain")
    public String hello() throws UnknownHostException {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost()
                    .getHostAddress();
        } catch (UnknownHostException e) {
            hostname = "unknown";
        }
        return "Hello Spring Boot: " + hostname;
    }

    // READ
    @RequestMapping("/user/read/{id}")
    @ResponseBody
    public String readUser(@PathVariable("id") long id) {
        User user;
        try {
            user = userRepository.findOne(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
        if (user == null) {
            String errorMessage = "No user found for id " + id;
            logger.error(errorMessage);
            return errorMessage;
        } else {
            return user.getId() + " : " + user.getName();
        }
    }

}
