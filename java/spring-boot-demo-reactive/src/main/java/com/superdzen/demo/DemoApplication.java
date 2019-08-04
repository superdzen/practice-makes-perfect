package com.superdzen.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Spring Boot 2.1 and Reactive Web sample
 * https://blog.alexnesterov.com/post/spring-your-next-microframework/
 */
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws InterruptedException {
        HandlerFunction hello = request -> ServerResponse.ok().body(Mono.just("Hello"), String.class);

        RouterFunction router = route(GET("/"), hello);

        HttpHandler httpHandler = RouterFunctions.toHttpHandler(router);

        HttpServer
                .create()
                .port(8080)
                .handle(new ReactorHttpHandlerAdapter(httpHandler))
                .bindNow();

        Thread.currentThread().join();
    }
}
