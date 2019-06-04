package com.srini.learning.springcloud.filter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class StopPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		Instant now = Instant.now();
		System.out.println("Stop Time : " + now);
		Instant startTime = (Instant) ctx.get("sTime");
		System.out.println("Total Round Time : " + ChronoUnit.MILLIS.between(startTime, now));
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;	
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
