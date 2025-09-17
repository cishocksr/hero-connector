package com.cishockley.hero.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {
    @Bean
    WebClient.Builder webClientBuilder() {
        var httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofSeconds(10))
                .doOnConnected(conn -> {
                    conn.addHandlerLast(new ReadTimeoutHandler(10, TimeUnit.SECONDS));
                    conn.addHandlerLast(new WriteTimeoutHandler(10, TimeUnit.SECONDS));
                });

        return WebClient.builder().clientConnector(new org.springframework.http.client.reactive.ReactorClientHttpConnector(httpClient));
    }
}
