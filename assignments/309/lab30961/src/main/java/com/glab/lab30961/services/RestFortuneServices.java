package com.glab.lab30961.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("restFortune")
//@Primary // automatically default to if not qualified
public class RestFortuneServices implements IFortuneServices{
    @Override
    public String getFortune() {
        return "The rest of the fortune is resting...";
    }
}
