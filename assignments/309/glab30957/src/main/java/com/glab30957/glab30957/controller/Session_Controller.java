package com.glab30957.glab30957.controller;

import com.glab30957.glab30957.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("u")
public class Session_Controller {

//    Add user in model attribute
    @ModelAttribute("u")
    public User setUpUserForm(){
        return new User();
    }

    @GetMapping("/dologin")
    public String doLogin(@ModelAttribute("u") User u, Model model){
        model.addAttribute("FormVar", u);
        return "UserForm";
    }

    @PostMapping("/Getuser")
    public String userInfo(@ModelAttribute("u") User user, Model model){
        System.out.println("Email: " + user.getEmail());
        System.out.println("First name: " + user.getName());
        System.out.println("Id: " + user.getId());
        model.addAttribute("student", user);
        return "showData";
    }
}
