package pluralsight.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;

//@EnableBinding(Source.class)
@EnableBinding(TollSource.class)
public class TollPublisher {
//	Random r = new Random();
//	int count = 0;
//
//	@Bean
////	@InboundChannelAdapter(channel = TollSource.fastToll, poller = @Poller(fixedDelay = "2000"))
//	public MessageSource<TollModel> sendToFastCharge() {
//		return () -> MessageBuilder.withPayload(new TollModel("1", "101", "" + new Date(), count++))
//				.setHeader("speed", r.nextInt(100)).setHeader("type", "fast").build();
//	};
//
//	@Bean
////	@InboundChannelAdapter(channel = TollSource.standardToll, poller = @Poller(fixedDelay = "2000"))
//	public MessageSource<TollModel> sendToStandardCharge() {
//		return () -> MessageBuilder.withPayload(new TollModel("1", "102", "" + new Date(), count))
//				.setHeader("speed", r.nextInt(100)).setHeader("type", "standard").build();
//	};
}
