package com.hamze.reactivelabblocking.controller;

import com.hamze.reactivelabblocking.service.*;
import com.hamze.reactivelabblocking.util.DBUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/reactive-lab")
@RequiredArgsConstructor
public class BlockingTest {

    private final ClientService service;
    private final DBUtil dbUtil;

    @PostMapping(path = "/blocking",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String testBlocking(@RequestBody String inputData) {
        return service.echoClient(inputData);
    }

    @GetMapping(path = "/entity-id")
    public Serializable getEntityId() {
        return dbUtil.getId();
    }
}
