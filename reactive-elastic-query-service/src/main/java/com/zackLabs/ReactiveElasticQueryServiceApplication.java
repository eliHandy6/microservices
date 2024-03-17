package com.zackLabs;

import com.zackLabs.config.JacksonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zackilabs", "com.zackLabs.*"})
@Import({JacksonConfiguration.class})
public class ReactiveElasticQueryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReactiveElasticQueryServiceApplication.class, args);
    }


}
