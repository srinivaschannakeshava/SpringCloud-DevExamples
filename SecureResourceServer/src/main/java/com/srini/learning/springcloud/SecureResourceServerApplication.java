package com.srini.learning.springcloud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini.learning.springcloud.model.TollUsage;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SecureResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureResourceServerApplication.class, args);
	}

	@GetMapping("/tolldata")
//	@PreAuthorize("#oauth2.hasScope('toll_read') and hasRole('ADMIN')")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') and #oauth2.hasScope('toll_read')")
	public List<TollUsage> getTollData() {
		TollUsage instance1 = new TollUsage("100", "station50", "B65GT1W", "2016-09-30T06:31:22");
		TollUsage instance2 = new TollUsage("101", "station19", "AHY673B", "2016-09-30T06:32:50");
		TollUsage instance3 = new TollUsage("102", "station50", "ZN2GP0", "2016-09-30T06:37:01");

		ArrayList<TollUsage> tolls = new ArrayList<TollUsage>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);

		return tolls;
	}

}
