package com.zackilabs.twitter.to.kafka.service;


import com.zackilabs.twitter.to.kafka.service.init.StreamInitializer;
import com.zackilabs.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.zackilabs", "com.zackLabs"})
public class TwitterToKafkaService implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaService.class);
    private final StreamInitializer streamInitializer;
    private final StreamRunner streamRunner;

    public TwitterToKafkaService(StreamInitializer streamInitializer, StreamRunner streamRunner) {
        this.streamInitializer = streamInitializer;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Application has started");
        streamInitializer.init();
        streamRunner.start();
    }
}
