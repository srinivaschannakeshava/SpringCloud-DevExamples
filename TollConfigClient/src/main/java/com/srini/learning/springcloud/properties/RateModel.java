package com.srini.learning.springcloud.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Component
@Getter
@Setter
public class RateModel {
private String rate;
private String tollstart;
private String tollstop;
private String lanecount;
private String secretMessage;	
	
}
