package com.srini.learning.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceAuthConfig {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(encoder.encode("srini91"));
		auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("srini").password(encoder.encode("srini91"))
				.roles("USER", "ADMIN").and().withUser("raghu").password(encoder.encode("raghu")).roles("USER");
	}

}
