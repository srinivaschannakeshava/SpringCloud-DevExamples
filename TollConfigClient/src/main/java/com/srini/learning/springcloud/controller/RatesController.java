package com.srini.learning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.learning.springcloud.properties.RateModel;

@RestController
public class RatesController {
	@Autowired
	RateModel rateModel;
	
	@GetMapping("/rate")
	public RateModel getRates() {
		return rateModel;
	}

}
