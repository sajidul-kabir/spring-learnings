package com.example.RestTemplate.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Controller
@ResponseBody
public class RestController {

    @Autowired
    RestService restService;

    // Sync call with RestTemplate
    @GetMapping("/")
    public String getRestcall() {
        return restService.getRestCall();
    }

    // Async call with web client
    @GetMapping("/web-client")
    public Mono<String> getRestCallViaWebClient() {
        return restService.getRestCallViaWebClient();
    }

}
