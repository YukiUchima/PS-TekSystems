package com.perscholas.TestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class MyController {
    @GetMapping({"/login"})   // either type '/' or index
    public String showlogin()
    {
        return "index";
    }

    @RequestMapping("/")
    public String simplemethod() {
        //mapped to hostname:port/home/
        return "inboxpage";
    }
    @RequestMapping("/index")
    public String showindex() {
        //mapped to hostname:port/home/index/
        return "inboxpage";
    }
}
