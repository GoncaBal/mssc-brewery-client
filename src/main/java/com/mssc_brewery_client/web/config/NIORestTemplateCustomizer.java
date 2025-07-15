package com.mssc_brewery_client.web.config;

import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.HttpComponentsClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class NIORestTemplateCustomizer  {

    @Bean
    public WebClient webClient() {
        IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                .setSoTimeout(Timeout.ofSeconds(3))
                .setIoThreadCount(4)
                .build();

        PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                .setMaxConnPerRoute(100)
                .setMaxConnTotal(1000)
                .setConnectionTimeToLive(TimeValue.ofMinutes(2))
                .build();

        CloseableHttpAsyncClient asyncClient = HttpAsyncClients.custom()
                .setConnectionManager(connectionManager)
                .setIOReactorConfig(ioReactorConfig)
                .build();

        asyncClient.start();

        return WebClient.builder()
                .clientConnector(new HttpComponentsClientHttpConnector(asyncClient))
                .build();
    }
}
