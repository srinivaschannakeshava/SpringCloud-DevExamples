package com.srini.learning.springcloud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class TollProcessingTaskSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollProcessingTaskSourceApplication.class, args);
	}

	@Autowired
	Source source;

	@RequestMapping("/runtask")
	public String intiateRunTask() {
		String url = "maven://com.srini.learning:TollProcessingTask:0.0.1-SNAPSHOT";
		TaskLaunchRequest tlr = new TaskLaunchRequest(url, Arrays.asList("hello", "hello2"), null, null, null);
		System.out.println("launch request created !!");
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<TaskLaunchRequest>(tlr);
		source.output().send(message);
		return "success";
	}
}
