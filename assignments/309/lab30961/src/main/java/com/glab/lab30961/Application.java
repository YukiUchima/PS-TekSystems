package com.glab.lab30961;

import com.glab.lab30961.services.ICoach;
import com.glab.lab30961.services.IFortuneServices;
import com.glab.lab30961.services.TennisCoach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
		SpringApplication.run(Application.class, args);

		ICoach theCoach = context.getBean(ICoach.class);
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());
//		context.close();

	}

}
