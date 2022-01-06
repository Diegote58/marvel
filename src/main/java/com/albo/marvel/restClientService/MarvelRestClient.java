package com.albo.marvel.restClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.net.URI;

public interface MarvelRestClient {

	ResponseEntity<?> makeRequest(URI url, Class<? extends Object> responseType) throws RestClientException;


}
