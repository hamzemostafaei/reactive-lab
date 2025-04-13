package com.hamze.reactivelabblocking.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(value = "/reactive-lab/blocking", produces = MediaType.APPLICATION_JSON_VALUE)
public class PingController {

    @PostMapping("/ping")
    public ResponseEntity<String> ping(@RequestBody(required = false) String ping) {
        if (!StringUtils.hasText(ping)) {
            return ResponseEntity.ok("Pong");
        } else {
            return ResponseEntity.ok(ping);
        }
    }
}
