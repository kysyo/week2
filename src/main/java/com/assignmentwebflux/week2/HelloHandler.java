package com.assignmentwebflux.week2;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.queryParam("name").get();
        Mono<HelloData> helloData = Mono.just(new HelloData(name, name));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(helloData, HelloData.class);
    }

}
