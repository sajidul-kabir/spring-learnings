package com.example.RestTemplate.RestTemplate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RestService {

public String getRestCall(){
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "https://jsonplaceholder.typicode.com/posts";

    return restTemplate.getForObject(resourceUrl, String.class);
}
public Mono<String> getRestCallViaWebClient(){
    WebClient client = WebClient.create("https://jsonplaceholder.typicode.com/posts");
    return client.get()
            .retrieve()
            .bodyToMono(String.class);
}
}
