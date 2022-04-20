package com.assignmentwebflux.week2;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.queryParam("name").get();

        // info-service/uri 에서 job 정보 받아오기 {"job": "Developer"}
        WebClient client = WebClient.create("http://localhost:8090");
        Mono<Map> getJob = client.get()
                .uri(builder ->
                        builder.path("/info-service/uri")
                                .queryParam("name", name)
                                .build()) // name을 파라미터로 job 조회
                .retrieve()
                .bodyToMono(Map.class)
                ;

        // job 정보 받아 새로운 VO 객체 만듬.
        Mono<HelloData> helloData = getJob.map(map-> new HelloData(name,"hello"+name, (String) map.get("job")));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(helloData, HelloData.class);
    }
}
