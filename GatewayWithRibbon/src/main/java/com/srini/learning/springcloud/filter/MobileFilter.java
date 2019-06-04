package com.srini.learning.springcloud.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MobileFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		String par = ctx.getRequest().getParameter("source");
		return par != null && par.equalsIgnoreCase("mobile");
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("Mobile Filter active!!");
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
