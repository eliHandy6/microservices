package com.zackLabs.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigServer
@ComponentScan(basePackages = {"com.zackilabs", "com.zackLabs"})
public class ConfigServer {

    public static void main(String args[]) {
        SpringApplication.run(ConfigServer.class, args);

    }



}
