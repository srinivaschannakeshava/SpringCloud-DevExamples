package com.srini.learning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.srini.learning.springcloud.filter.MobileFilter;
import com.srini.learning.springcloud.filter.StartPreFilter;
import com.srini.learning.springcloud.filter.StopPostFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableHystrix
public class GatewayWithRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayWithRibbonApplication.class, args);
	}

	@Bean
	public MobileFilter getMobileFilter() {
		return new MobileFilter();
	}

	@Bean
	public StartPreFilter getStartPreFilter() {
		return new StartPreFilter();
	}

	@Bean
	public StopPostFilter getStopPostFilter() {
		return new StopPostFilter();
	}

}
