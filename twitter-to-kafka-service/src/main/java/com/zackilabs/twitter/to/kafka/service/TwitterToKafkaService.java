package com.zackilabs.twitter.to.kafka.service;


import com.zackilabs.appconfigdata.config.TwitterToKafkaConfigData;
import com.zackilabs.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;


@SpringBootApplication
@ComponentScan(basePackages = "com.zackilabs")
public class TwitterToKafkaService implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaService.class);
    private final TwitterToKafkaConfigData twitterToKafkaConfigData;
    private final StreamRunner streamRunner;

    public TwitterToKafkaService(TwitterToKafkaConfigData twitterToKafkaConfigData, StreamRunner streamRunner) {
        this.twitterToKafkaConfigData = twitterToKafkaConfigData;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Application has started");
        LOG.info(Arrays.toString(twitterToKafkaConfigData.getTwitterKeyWords().toArray(new String[]{})));
        LOG.info(twitterToKafkaConfigData.getMessage());
        streamRunner.start();
    }
}
