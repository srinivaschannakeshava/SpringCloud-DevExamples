package com.srini.learning.springcloud;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TollProcessingTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollProcessingTaskApplication.class, args);
	}
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner{
		@Override
		public void run(String... args) throws Exception {
			//parameters stationid ,licenceplate, timestamp
			
			if(null!=args) {
				System.out.println(Arrays.deepToString(args)+" : paramters length: "+args.length);
			}
		}
	}

}
