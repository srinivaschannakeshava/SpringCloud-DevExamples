package com.srini.learning.springcloud;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class DefaultFallBack {

	/*
	 * @Override public String getRoute() { return null; }
	 * 
	 * @Override public ClientHttpResponse fallbackResponse(String route, Throwable
	 * cause) { if (cause instanceof HystrixTimeoutException) { return
	 * response(HttpStatus.GATEWAY_TIMEOUT); } else { return
	 * response(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 * 
	 * private ClientHttpResponse response(HttpStatus status) {
	 * 
	 * return new ClientHttpResponse() {
	 * 
	 * @Override public HttpHeaders getHeaders() { HttpHeaders headers = new
	 * HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON); return
	 * headers; }
	 * 
	 * @Override public InputStream getBody() throws IOException { return new
	 * ByteArrayInputStream(
	 * "{\"factorA\":\"Sorry, Service is Down!\",\"factorB\":\"?\",\"id\":null}"
	 * .getBytes()); }
	 * 
	 * @Override public String getStatusText() throws IOException { return
	 * status.getReasonPhrase(); }
	 * 
	 * @Override public HttpStatus getStatusCode() throws IOException { return
	 * status; }
	 * 
	 * @Override public int getRawStatusCode() throws IOException { return
	 * status.value(); }
	 * 
	 * @Override public void close() {
	 * 
	 * } };
	 * 
	 * }
	 */

	@Bean
	public FallbackProvider zuulFallbackProvider() {
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				// Might be confusing: it's the serviceId property and not the route
				return "*";
			}

			@Override
			public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
				return new ClientHttpResponse() {
					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.OK.value();
					}

					@Override
					public String getStatusText() throws IOException {
						return HttpStatus.OK.toString();
					}

					@Override
					public void close() {
					}

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream(
								"{\"factorA\":\"Sorry, Service is Down!\",\"factorB\":\"?\",\"id\":null}".getBytes());
					}

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}
				};
			}

		};
	}
}
