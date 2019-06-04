package com.srini.learning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class FasspassTollIntakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FasspassTollIntakeApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='fast'")
	public void fastMessageListner(String data) {
		System.out.println("Fast Processor : " + data);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='standard'")
	public void standardMessageListner(String data) {
		System.out.println("Standard Processor : " + data);
	}

}
