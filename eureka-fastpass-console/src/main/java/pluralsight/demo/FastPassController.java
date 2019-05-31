package pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class FastPassController {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFastPassCustomerDetailsFallBack")
	@RequestMapping(path = "/customerdetails", params = { "fastpassid" })
	public String getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {

		FastPassCustomer c = restTemplate.getForObject("http://fastpass-service/fastpass?fastpassid=" + fastpassid,
				FastPassCustomer.class);
		System.out.println("retrieved customer details");
		m.addAttribute("customer", c);
		return "console";
	}

	public String getFastPassCustomerDetailsFallBack(String fastpassid, Model m) {
		return "500";
	}

}
