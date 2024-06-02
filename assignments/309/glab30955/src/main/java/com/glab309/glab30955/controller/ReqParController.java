package com.glab309.glab30955.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ReqParController {

    @GetMapping("/request1")
    public String handler(@RequestParam(name="whatisthis") String name){
        return "URL parameter <br> name= " + name;
    }

    @GetMapping("/request2")
    public String handler(@RequestParam String firstName, @RequestParam String lastName){
        return "URL parameters - <br> firstName=" + firstName + "<br> lastName=" + lastName;
    }

    @GetMapping("/request3")
    public String handler(@RequestParam("name") String name,
                          @RequestParam("age") String age,
                          @RequestParam("amount") String amount,
                          @RequestParam("active") String active){
        return "URL parameters - <br> name=" + name +
                "<br> age=" + age +
                "<br> amount=" + amount +
                "<br> active=" + active;
    }

    /* Binding all request parameters to Map   */
    //Example: http://localhost:8080/request4?name=David&age=32&country=USA&city=NewYork
    @GetMapping("/request4")
    public String handler(@RequestParam Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("URL parameters - <br>");
        for(Map.Entry<String, String> entry: params.entrySet()){
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return builder.toString();
    }

    /* The required=false attribute of @RequestParam annotation is used
        to make a method parameter as Optional i.e. it binds a null value to a method parameter if the request
        parameter is not present.  */

    @GetMapping("/request5")
    public String handler(@RequestParam("firstname") String fName,
                          @RequestParam(name="middleName", required = false) String mName,
                          @RequestParam("lastName") String lName){
        return "URL Parameters - <br> firstName= " +fName+
                "<br> middleName= " + mName +"<br> lastName= " +lName;
    }

    /*  Binding date and time request parameters to LocalDate and LocalTime using @DateTimeFormat and @RequestParam    */
//    EX: http://localhost:8080/request6?date=2017-12-12&time=12:54:52
    @GetMapping("/request6")
    public String handler(
            @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("date")LocalDate date,
            @DateTimeFormat(pattern="HH:mm:ss") @RequestParam("time")LocalTime time
            ){
        return "URL PARAMETERS - <br> date= " + date + "<br> time= " + time;
    }
//    http://localhost:8080/request7?country=USA&country=PAKISTAN&country=Japan&city=NYC&city=KARACHI&city=TOKYO
    @GetMapping("/request7")
    public String handler(@RequestParam("country") String[] country,
                          @RequestParam("city") List<String> city){
        return "URL parameters - <br> country= " + Arrays.asList(country) +
                "<br> city= "+city;
    }

    @GetMapping("/request8")
    public String handler(@RequestParam(name = "code", defaultValue = "10") int code
    ) {
        return "URL parameters - <br>" + " code = " + code;
    }

}
