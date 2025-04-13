package com.example.reactivelabnoneblocking.controller;

import com.example.reactivelabnoneblocking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/reactive-lab", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class NonBlockingTest {

    private final ClientService service;

    @PostMapping(path = "/non-blocking")
    public Mono<String> testNonBlocking(@RequestBody String inputData) {
        return service.echoClient(inputData);
    }
}
