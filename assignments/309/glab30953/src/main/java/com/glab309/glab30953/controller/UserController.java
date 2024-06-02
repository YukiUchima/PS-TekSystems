package com.glab309.glab30953.controller;

import com.glab309.glab30953.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @ModelAttribute("blah")
    public List<String> getUserCountries(){
        List<String> countries = new ArrayList<>();
        countries.add("UK");
        countries.add("USA");
        countries.add("Japan");
        return countries;
    }

    @ModelAttribute
    public void getUsers(Model model){
        User u1 = new User(1, "johnnyBoy", "jB@gmail.com");
        User u2 = new User(2, "shane", "shane@gmail.com");
        User u3 = new User(3, "thirdUser", "change@gmail.com");
        List<User>  myuser = new ArrayList<>();
        myuser.add(u1);
        myuser.add(u2);
        myuser.add(u3);
        model.addAttribute("myUserListisHere",myuser);
    }

    @GetMapping("/Home")
    public String home(@ModelAttribute("blah") List<String>prevCreated, Model model){
        prevCreated.add("Aus");
        prevCreated.add("LAST ONE");
        return "home";
    }
}
