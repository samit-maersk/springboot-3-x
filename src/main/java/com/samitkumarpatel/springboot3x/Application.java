package com.samitkumarpatel.springboot3x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
@Configuration
class Router {
	@Bean
	public RouterFunction route() {
		return RouterFunctions.route().GET("/",accept(MediaType.TEXT_PLAIN), request -> ServerResponse.ok().body(Mono.just("Hello World"), String.class)).build();
	}
}