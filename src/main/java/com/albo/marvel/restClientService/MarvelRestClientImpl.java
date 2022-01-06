package com.albo.marvel.restClientService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class MarvelRestClientImpl implements MarvelRestClient {


	protected final Log logger = LogFactory.getLog(getClass());

	private RestTemplate restTemplate;

	public MarvelRestClientImpl() {
		this.restTemplate =	new RestTemplateBuilder().build();
	}
	
	public ResponseEntity<?> makeRequest(URI url, Class<? extends Object> responseType) {
		ResponseEntity<?> response = null;
		try {
			response = this.restTemplate.getForEntity(url, responseType);
		}catch (RestClientException e){
			logger.error("makeRequest.RestClientException: " + e.getMessage());
			throw e;
		}
		return response;
	}

}
