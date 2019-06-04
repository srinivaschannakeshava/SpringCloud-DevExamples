package com.srini.learning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class TollProcessingTaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollProcessingTaskSinkApplication.class, args);
	}

}
