package com.srini.learning.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TollUsage {
	public String Id;
	public String stationId;
	public String licensePlate;
	public String timestamp;
}
