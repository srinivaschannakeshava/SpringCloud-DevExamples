package pluralsight.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TollSource {
	String fastToll = "fastpasstoll";
	String standardToll = "standardpasstoll";

	@Output(fastToll)
	MessageChannel fastPassToll();

	@Output(standardToll)
	MessageChannel standardPassToll();
}
