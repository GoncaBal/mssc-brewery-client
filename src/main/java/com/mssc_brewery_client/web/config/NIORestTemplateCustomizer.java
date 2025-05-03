package com.mssc_brewery_client.web.config;

import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.reactor.DefaultConnectingIOReactor;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class NIORestTemplateCustomizer implements RestTemplateCustomizer {

    //impl
    /*public ClientHttpRequestFactory clientHttpRequestFactory(){
        final DefaultConnectingIOReactor ioreactor = new DefaultConnectingIOReactor(IOReactorConfig
                .custom()
                .setSoTimeout(Timeout.ofMilliseconds(3000))
                .setIoThreadCount(4)
                .build());

        final PoolingHttpClientConnectionManager connectionManager= new PoolingHttpClientConnectionManager(ioreactor);
        connectionManager.setDefaultMaxPerRoute(100);
        connectionManager.setMaxTotal(1000);

        CloseableHttpAsyncClient httpAsyncClient= HttpAsyncClients.custom()
                .setConnectionManager(connectionManager)
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpAsyncClient);
    }*/
    @Override
    public void customize(RestTemplate restTemplate) {
       // restTemplate.setRequestFactory(clientHttpRequestFactory());
    }
}
