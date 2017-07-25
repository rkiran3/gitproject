package com.sandbox.springbootwebjdbc.springbootwebjdbc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public @ResponseBody String greeting(
    //public String greeting(
            @RequestParam(value="name", required=false, defaultValue="World")
            String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
