package com.hoan.springplayground.springboot3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * RestClient는 Spring Boot 3.2부터 도입된 새로운 HTTP 클라이언트.
 *
 * 기존의 RestTemplate, WebClient보다 간단하고 직관적인 사용성을 강조한 고수준 API.
 *
 * RestClient는 RestTemplate을 대체하는 것이 목표.
 *
 * WebClient랑은 사용 환경과 목적 다름.
 * WebClient는 비동기식, 논블로킹 사용 철학이 있음.
 *
 */
public class RestClientPractice {
    public static void main(String[] args) {
        restClientPractice();
        restTemplatePractice();
        webClientPractice();

    }

    private static void restClientPractice() {
        RestClient restClient = RestClient.create();

        String body = restClient.get().uri("https://httpbin.org/get").retrieve().body(String.class);

        System.out.println(body);
    }

    private static void restTemplatePractice() {
        // 1. RestTemplate 인스턴스 생성
        RestTemplate restTemplate = new RestTemplate();

        // 2. 요청 URL
        String url = "https://httpbin.org/get";

        // 3. GET 요청 및 응답 받기
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // 4. 결과 출력
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }

    private static void webClientPractice() {
        WebClient webClient = WebClient.create();

        Mono<String> response = webClient.get()
                .uri("https://httpbin.org/get")
                .retrieve()
                .bodyToMono(String.class);

        // 구독(subscribe)해야 실제 요청이 전송됨
        response.subscribe(System.out::println);

        // 메인 쓰레드가 바로 종료되지 않도록 약간 대기
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

    }


}
