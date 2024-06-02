package com.glab309.glab30956.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class pathVarController {

    @GetMapping("/request1/{name}")
    public String handler(@PathVariable(name="name") String name){
        return "URL Parameter name: " + name;
    }

    @GetMapping("/request2/{firstName}/{lastName}")
    public String handler(@PathVariable String firstName, @PathVariable String lastName){
        return "URL Parameter firstName: " + firstName + "lastName: " + lastName;
    }

    /*  If the method parameter type is not String then Spring automatically converts to the appropriate type such as int, long, float, etc.   */
    @GetMapping("/request3/{name}/{age}/{salary}/{active}")
    public String handler(@PathVariable("name") String name,
                          @PathVariable("age") int age,
                          @PathVariable("salary") double salary,
                          @PathVariable("active") boolean active) {
        return "URL parameters - <br>"
                + " name = " + name + " <br>"
                + " age = " + age + " <br>"
                + " salary = " + salary
                + " <br>" + " active = " + active;
    }

    /* Binding all URI template variables to Map  */
    @GetMapping("/request4/{name}/{age}/{address}/{city}/{country}")
        public String handler(@PathVariable Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("URL parameters - <br>");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return builder.toString();
    }
    /*Binding date and time URL template variable to LocalDate and LocalTime   */
    @GetMapping("/request5/{date}/{time}")
        public String handler(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") LocalDate date,
            @DateTimeFormat(pattern = "HH:mm:ss") @PathVariable("time") LocalTime time) {
        return "URL parameters - <br>"
                + " date = " + date + " <br>"
                + " time = " + time;
    }
    /*Binding URI template variable to array and list  */
    @GetMapping("/request6/{country}/{city}")
        public String handler(@PathVariable("country") String[] country,
                          @PathVariable("city") List<String> city) {
        return "URL parameters - <br>"
                + " country = " + Arrays.asList(country) + " <br>"
                + " city = " + city;
    }

}
