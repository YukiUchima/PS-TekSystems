package com.glab.lab30961.services;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@NoArgsConstructor
public class TennisCoach implements ICoach{

    @Autowired
    @Qualifier("happyFortune")
    private IFortuneServices iFortuneService;

    public TennisCoach(){}  // default constructor

//    @Autowired // autowiring constructor
    public TennisCoach(IFortuneServices aFortuneService){
        iFortuneService = aFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your 3-point throw!";
    }

    @Override
    public String getDailyFortune() {
        return iFortuneService.getFortune();
    }
}
