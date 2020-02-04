package com.evan.demo.user;

import com.evan.transaction.integration.resttemplate.client.ClientTransactionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.evan.demo.user.mapper")
public class UserServiceApplication {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public static void main(String[] args) {
        try {
            SpringApplication.run(UserServiceApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new ClientTransactionInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
