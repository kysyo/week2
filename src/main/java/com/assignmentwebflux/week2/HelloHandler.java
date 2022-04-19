package com.assignmentwebflux.week2;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.queryParam("name").get();

        // info-service/uri 에서 JOB정보 받아오기
        WebClient client = WebClient.create("http://localhost:8090");
//        Mono<Object> getJob = client.get()
//                .uri(builder -> builder.path("/info-service/uri").queryParam("name", name).build())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Object.class)
//                ;

//        Mono<Map> getJob = client.get()
//                .uri(builder -> builder.path("/info-service/uri").queryParam("name", name).build())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Map.class)
//                ;

        Mono<String> getJob = client.get()
                .uri(builder -> builder.path("/info-service/uri").queryParam("name", name).build())
                .retrieve()
                .bodyToMono(String.class)
//                .map(data -> data.getJob)
                .log()
//                .subscribe(ss->)
                ;
//        Map<String, Object> testMono = client.get()
//                .uri("/info-service/uri?name="+name)
//                .retrieve()
//                .bodyToMono(Map.class).block()
//                ;
        System.out.println(getJob);

//        System.out.println(getJob.toString());

        Mono<HelloData> helloData = Mono.just(new HelloData(name, name, "test"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(helloData, HelloData.class);
    }

}
