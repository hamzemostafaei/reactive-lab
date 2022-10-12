package com.hamze.reactivelabblocking.controller;

import com.hamze.reactivelabblocking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reactive-lab")
@RequiredArgsConstructor
public class BlockingTest {

    private final ClientService service;

    @PostMapping(path = "/blocking",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String testBlocking(@RequestBody String inputData) {
        return service.echoClient(inputData);
    }
}
