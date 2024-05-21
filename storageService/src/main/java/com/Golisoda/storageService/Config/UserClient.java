package com.Golisoda.storageService.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Data
public class UserClient  {
    @Value("${rest.userService.uri}")
    private String userBaseUrl;

    @Bean(name = "userServiceClient")
    public WebClient userServiceClient() {
        return WebClient.builder()
                .baseUrl(userBaseUrl)
                .build();
    }
}

