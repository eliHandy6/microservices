package com.zackLabs.business.impl;


import com.zackLabs.elasticmodel.index.impl.TwitterIndexModel;
import com.zackilabs.appconfigdata.config.ElasticQueryServiceConfigData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.zackLabs.business.ReactiveElasticQueryClient;
import com.zackLabs.repository.ElasticQueryRepository;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class TwitterReactiveElasticQueryClient implements ReactiveElasticQueryClient<TwitterIndexModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterReactiveElasticQueryClient.class);

    private final ElasticQueryRepository elasticQueryRepository;

    private final ElasticQueryServiceConfigData elasticQueryServiceConfigData;

    public TwitterReactiveElasticQueryClient(ElasticQueryRepository elasticRepository,
                                             ElasticQueryServiceConfigData configData) {
        this.elasticQueryRepository = elasticRepository;
        this.elasticQueryServiceConfigData = configData;
    }


    @Override
    public Flux<TwitterIndexModel> getIndexModelByText(String text) {
        LOG.info("Getting data from elasticsearch for text {}", text);
        return elasticQueryRepository
                .findByText(text)
                .delayElements(Duration.ofMillis(elasticQueryServiceConfigData.getBackPressureDelayMs()));
    }
}
