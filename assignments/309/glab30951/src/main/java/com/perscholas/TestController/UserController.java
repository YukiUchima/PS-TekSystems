package com.perscholas.TestController;

import com.perscholas.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public void printData(@RequestBody User user){
        System.out.println("Printing user data: " + user);
    }

}
