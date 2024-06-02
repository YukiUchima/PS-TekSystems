package com.glab.lab30961.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class DatabaseFortuneService implements IFortuneServices{
    @Override
    public String getFortune() {
        return "The db says.... the dragon bites";
    }
}
