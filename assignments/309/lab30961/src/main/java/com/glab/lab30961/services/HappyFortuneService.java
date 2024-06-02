package com.glab.lab30961.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("happyFortune")
public class HappyFortuneService implements IFortuneServices{
    @Override
    public String getFortune() {
        return "Today is your lucky day since i've been autowired!";
    }
}
