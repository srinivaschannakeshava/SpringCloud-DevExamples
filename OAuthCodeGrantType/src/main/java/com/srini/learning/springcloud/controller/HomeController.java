package com.srini.learning.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srini.learning.springcloud.bean.TollUsage;

@Controller
@EnableOAuth2Sso
public class HomeController extends WebSecurityConfigurerAdapter {

	@Autowired
	OAuth2ClientContext context;

	@Autowired
	OAuth2RestTemplate restTemplate;

	@RequestMapping("/home")
	public String getHomePage() {
		System.out.println(context.getAccessToken());
		ResponseEntity<List<TollUsage>> exchange = restTemplate.exchange("http://localhost:9002/services/tolldata", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TollUsage>>() {

				});
		return "home";
	}

	@RequestMapping("/logon")
	public String getLoginPage() {
		return "logon";
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/logon", "/login**").permitAll().anyRequest().authenticated();
	}

}
