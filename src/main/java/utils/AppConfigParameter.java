package utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigParameter {
	
	@Value("${localswapi.apiurl.planets}")
	private String planetsUrl;
	@Value("${localswapi.apiurl}")
	private String url;
	
	public AppConfigParameter() {

	}
	
	public String getPlanetsUrl() {
		return planetsUrl;
	}

	public String getUrl() {
		return url;
	}

}
