package com.localswapi.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.localswapi.domain.PagePlanetApi;

public class ApiUtils {

	
	private static final String PLANETS_URL = "https://swapi.co/api/planets/";
	//private static final String API_URL = " https://swapi.co/api/";
	
	public ApiUtils() {
	
	}

	public static PagePlanetApi findPlanets(String value) throws Exception {
	
	RestTemplate restTemplate = new RestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	headers.add("User-Agent", "Mozilla/5.0");
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    System.out.println(PLANETS_URL + "?search="+ value);
    HttpEntity<String> response = restTemplate.exchange( PLANETS_URL+ "?search="+ value, HttpMethod.GET, new HttpEntity<>(headers), String.class);

    PagePlanetApi page = new Gson().fromJson(response.getBody(), PagePlanetApi.class);
	return page;
    
	}
	
	public static List<PagePlanetApi> listAllPlanets() throws Exception {

	RestTemplate restTemplate = new RestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	headers.add("User-Agent", "Mozilla/5.0");
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);

    
    
    List<PagePlanetApi> pagePlanetsApi =new ArrayList<>();
    HttpEntity<String> response; 
    PagePlanetApi page;
    String url = PLANETS_URL;
    
	do{
		response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
	    page = (PagePlanetApi) new Gson().fromJson(response.getBody(), PagePlanetApi.class);
		pagePlanetsApi.add(page);
		url = page.getNext();
	}while (page.getNext()!=null);

	return pagePlanetsApi;
    
	}
}
