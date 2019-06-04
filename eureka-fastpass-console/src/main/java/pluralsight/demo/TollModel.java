package pluralsight.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TollModel {
	private String stationId;
	private String customerId;
	private String timeStamp;
	private int count;
}
