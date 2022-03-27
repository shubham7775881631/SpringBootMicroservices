package com.infy.gateway.zuul.InfyGatewayZuul;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import com.netflix.hystrix.exception.HystrixTimeoutException;

@Configuration
public class ZuulConfigForHystrix implements FallbackProvider {
	
   //Method-1
	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return null;
	}
	
    //Method-2
	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

		if (cause instanceof HystrixTimeoutException) {
			return response(org.springframework.http.HttpStatus.GATEWAY_TIMEOUT);
		} else {
			return response(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	//Calling the response Method
	private ClientHttpResponse response(final org.springframework.http.HttpStatus status) {
		return new ClientHttpResponse() {

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.TEXT_PLAIN);
				return headers;
			}

			@Override
			public InputStream getBody() throws IOException {

				return new ByteArrayInputStream("Sorry!, Something went wrong.....Please Retry again".getBytes());
			}

			@Override
			public String getStatusText() throws IOException {

				return "OK";
			}

			@Override
			public org.springframework.http.HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return org.springframework.http.HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {

				return 200;
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub

			}
		};
	}

}
