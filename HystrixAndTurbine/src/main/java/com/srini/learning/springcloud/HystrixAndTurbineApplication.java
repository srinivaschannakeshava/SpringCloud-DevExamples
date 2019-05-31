package com.srini.learning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//@EnableTurbine
public class HystrixAndTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixAndTurbineApplication.class, args);
	}

}
