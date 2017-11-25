package com.instachange.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;

@SpringBootApplication
public class AlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlphaApplication.class, args);
		init();
	}

	public static void init(){
		Timer timer = new Timer();
		timer.schedule(new Refresher(), 0, 5000);
	}
}
