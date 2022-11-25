package com.indusnet.tiny;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class Tiny {

	
	@Autowired
    private RestTemplate restTemplate;
	
	public String shortUrl(String longUrl) {

		    HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(List.of(MediaType.ALL));
	        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
	        TinyUrl tinyUrlBody = new TinyUrl();
	        tinyUrlBody.setUrl(longUrl);
	        HttpEntity<TinyUrl> entity = new HttpEntity<TinyUrl>(tinyUrlBody, headers);
	        String tinyUrl = "https://api.tinyurl.com/create?api_token=HQyufbDmK9iCpmRIU5F3LXEE2c5xwsxJUg03TMMlL2IZhKgMJS4GdkUmj2iq";
	        TinyResponse tinyUrlResponse = restTemplate.exchange(tinyUrl, HttpMethod.POST, entity,
	        TinyResponse.class)
	                .getBody();
	        System.out.println(tinyUrlResponse);
	        return tinyUrlResponse.getData().getTiny_url();
		
	}
}
