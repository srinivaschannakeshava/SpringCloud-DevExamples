package pluralsight.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastpassRestController {

	@Autowired
	TollSource tollSource;
	private int count = 0;
	private Random r = new Random();

	@RequestMapping(path = "/toll", method = RequestMethod.POST)
	public String publishMessage(@RequestBody TollModel toll, @RequestParam String ctype) {

		tollSource.fastPassToll().send(
				MessageBuilder.withPayload(toll).setHeader("speed", r.nextInt(100)).setHeader("type", ctype).build());
		return "success";
	}

}
