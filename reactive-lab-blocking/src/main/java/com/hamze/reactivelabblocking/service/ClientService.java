package com.hamze.reactivelabblocking.service;

import com.squareup.okhttp.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ClientService {

    public String echoClient(String inputData) {

        log.debug("echoClient({}) just started...", inputData);

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, inputData);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8081/reactive-lab/echo")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();

            String string = response.body().string();

            log.debug("echoClient({}) finished.", inputData);

            return string;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}